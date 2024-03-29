"use strict";

/**
 * 主にサーバとの通信を制御するUtils暮らす。
 */
class ServerUtils {
    constructor() {
        this._xhr = new XMLHttpRequest();
    }

    /**
     * URL指定でサーバから結果を値(オブジェクト)としてそのまま返す。
     */
    getValue(url) {
        const xhr = this._xhr;
        xhr.open("GET", url, false);
        xhr.send();

        return xhr.responseText;
    }

    /**
     * URL指定でサーバから結果を値(オブジェクト)としてそのまま返す (POSTで)。
     */
    postValue(url, sendValue) {
        const xhr = this._xhr;
        xhr.open("POST", url, false);
        if (sendValue) {
            const sendJson = JSON.stringify(sendValue);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.send(sendJson);
        } else {
            xhr.send();
        }

        const jsonText = xhr.responseText;
        if (!jsonText) return undefined;
        return JSON.parse(jsonText);
    }

    /**
     * URL指定でサーバから結果をJSONオブジェクトにして返す。
     */
    getJson(url) {
        const jsonText = this.getValue(url);
        return JSON.parse(jsonText);
    }
}

module.exports = ServerUtils;
