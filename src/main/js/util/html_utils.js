'use strict';

/**
 * HTMLに関する操作(プラスこのアプリ固有の操作を少し)を集めたUtilityクラス。
 */
class HtmlUtils {

    constructor(doc = null) {
        if (doc === null) {
            this._document = window.document;
        } else {
            this._document = doc;
        }
    }

    /**
     * ID指定でDOMオブジェクトに値をセットする。
     */
    setTextById(id, text) {
        const document = this._document;
        const target = document.getElementById(id);
        target.textContent = text;
    }

    /**
     * ID指定でimgタグのsrcにurlにセットする。
     */
    setImageSrcById(id, imageUrl) {
        const document = this._document;
        const target = document.getElementById(id);
        target.src = imageUrl;
    }

    /**
     * 指定されたURLへとリダイレクトする。
     */
    redirect(url) {
        this._document.location = url;
    }

    /**
     * Elementに'click'のイベントでリスナーを追加する。
     */
    addClickEventById(id, func) {
        this._document.getElementById(id).addEventListener('click', func);
    }

    /**
     * Elementの表示・非表示を切り替える。
     */
    visibleChangeById(id, visible) {
        const displayState = visible ? 'block' : 'none';
        this._document.getElementById(id).style.display = displayState;
    }

    getElementById(id) {
        return this._document.getElementById(id);
    }

    getInputText(id) {
        return this.getElementById(id).value;
    }

}

module.exports = HtmlUtils;