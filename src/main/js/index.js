'use strict';

// クラスインポート。
const MainPage = require('./page/main');

/** HTMLとの境界、エントリポイント。 */
window.onload = function() {
    (new MainPage()).startUp();
}
