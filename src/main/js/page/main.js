"use strict";

const ServerUtils = require("../util/server_utils");
const HtmlUtils = require("../util/html_utils");

class MainPage {
    constructor(htmlUtils = null) {
        this.REDRAW_MS = 200;

        // テスト時にMockして動かせるように。
        this._html = htmlUtils === null ? new HtmlUtils() : htmlUtils;
        this._server = new ServerUtils();
    }

    /**
     * 「start」クリックイベント。
     */
    startLifeGame(e, html, server) {
        this.startButtonVisible(false);

        const condition = this.getInputWorldCondition();
        server.postValue("api/gameOfLife/initialize", condition);

        this.drawWorld(html, () => server.getJson("api/gameOfLife/getMatrix"));
    }

    /**
     * 「stop」ボタンクリックイベント。
     */
    endLifeGame(e, html, server) {
        clearInterval(this.timer);
        this.startButtonVisible(true);
    }

    /**
     * 無限ループでライフゲームの表情報を取得し、描画し続ける。
     * @param receiveNextMatrix 外から受け取る「サーバから次の世代の表情報を受信する」をクロージャ。
     */
    drawWorld(html, receiveNextMatrix) {
        const canvas = this._html.getElementById("matrixCanvas");
        const context = canvas.getContext("2d");
        const canvasWidth = canvas.width;
        const canvasHeight = canvas.height;
        let generation = 1;

        this.timer = setInterval(() => {
            const matrix = receiveNextMatrix();

            const rowCount = matrix.length;
            const columnCount = matrix[0].length;

            const cellWidth = canvasWidth / columnCount;
            const cellHeight = canvasHeight / rowCount;

            context.clearRect(0, 0, canvasWidth, canvasHeight);

            let allDead = true;
            for (let row = 0; row < rowCount; row++) {
                for (let column = 0; column < columnCount; column++) {
                    if (matrix[row][column]) {
                        allDead = false;
                        const left = cellWidth * column;
                        const top = cellHeight * row;
                        context.fillRect(left, top, cellWidth, cellHeight);
                    }
                }
            }

            if (allDead) {
                alert("ゲーム終了。全ての生物が死滅しました。最終世代:" + generation);
                this.startButtonVisible(true);
                clearInterval(this.timer);
            }

            generation++;
        }, this.REDRAW_MS);
    }

    /**
     * start/stopのボタン表示を切り替える。
     */
    startButtonVisible(visible) {
        this._html.visibleChangeById("startLifeGame", visible);
        this._html.visibleChangeById("stopLifeGame", !visible);
    }

    /**
     * 入力状態から、
     */
    getInputWorldCondition() {
        return {
            columnCount: this._html.getInputText("columnCount"),
            rowCount: this._html.getInputText("rowCount"),
        };
    }

    /**
     * index画面のOnLoad
     */
    startUp() {
        const server = this._server;
        const html = this._html;
        // イベント定義。
        html.addClickEventById("startLifeGame", (e) => this.startLifeGame(e, html, server));
        html.addClickEventById("stopLifeGame", (e) => this.endLifeGame(e, html, server));
    }
}

module.exports = MainPage;
