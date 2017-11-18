'use strict';

const ServerUtils = require('../util/server_utils');
const HtmlUtils = require('../util/html_utils');

class MainPage {

    constructor(htmlUtils = null) {

        this.REDRAW_MS = 200;

        // テスト時にMockして動かせるように。
        if (htmlUtils == null) {
            this._html = new HtmlUtils();
        } else {
            this._html = htmlUtils;
        }
        this._server = new ServerUtils();
    }

    /**
     * 「start」クリックイベント。
     */
    startLifeGame(e, html, server) {

        this.startButtonVisible(false);

        const condition = this.getInputWorldCondition();
        server.postValue('api/gameOflife/initialize', condition);

        const canvas = this._html.getElementById('matrixCanvas');
        const context = canvas.getContext('2d');
        const canvasWidth = canvas.width;
        const canvasHeight = canvas.height;

        this.timer = setInterval(() => {
            const matrix = server.getJson('api/gameOflife/getMatrix');

            const columnCount = matrix[0].length;
            const rowCount = matrix.length;

            const cellWidth = canvasWidth / columnCount;
            const cellHeight = canvasHeight / rowCount;

            context.clearRect(0, 0, canvasWidth, canvasHeight);

            for (let column = 0; column < columnCount; column++) {
                for (let row = 0; row < rowCount; row++) {
                    if (matrix[column][row]) {
                        const left = cellWidth * column;
                        const top = cellHeight * row;
                        context.fillRect(left, top, cellWidth, cellHeight);
                    }
                }
            }
        }, this.REDRAW_MS);

    }

    /**
     * 「stop」ボタンクリックイベント。
     */
    endLifeGame(e, html, server) {
        clearInterval(this.timer);
        this.startButtonVisible(true);
    }

    /**
     * start/stopのボタン表示を切り替える。
     */
    startButtonVisible(visible) {
        this._html.visibleChangeById('startLifeGame', visible);
        this._html.visibleChangeById('stopLifeGame', !visible);
    }

    getInputWorldCondition() {
        return JSON.stringify({
            "columnCount": this._html.getInputText('columnCount'),
            "rowCount": this._html.getInputText('rowCount')
        });
    }

    /**
     * index画面のOnLoad
     */
    startUp() {
        const server = this._server;
        const html = this._html;
        // イベント定義。
        html.addClickEventById('startLifeGame', (e) => this.startLifeGame(e, html, server));
        html.addClickEventById('stopLifeGame', (e) => this.endLifeGame(e, html, server));
    }

}

module.exports = MainPage;