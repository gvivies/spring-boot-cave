//= require application.js
//= require_self

(function () {
    'use strict';

    angular.module('cave').constant('Constants', {
        "REGIONS_URI": "regions",
        "WINES_URI": "wines",
        "BOTTLES_URI": "bottles",
        "DRINK_BOTTLE_URI": "bottles/drink",
        "WINERIES_URI": "dealers",
        "CLASSIFICATIONS_URI": "classifications",
        "EDIT_ITEM_EVENT": "EDIT_ITEM_EVENT",
        "CREATED_ITEM_EVENT": "CREATED_ITEM_EVENT",
        "UPDATED_ITEM_EVENT": "UPDATED_ITEM_EVENT",
        "DELETED_ITEM_EVENT": "DELETED_ITEM_EVENT",
        "DISPLAY_MSG_EVENT": "DISPLAY_MSG_EVENT",
        "HIDE_MENU_EVENT": "HIDE_MENU_EVENT",
        "SHOW_MENU_EVENT": "SHOW_MENU_EVENT",
        "ADD_CLICK_EVENT": "ADD_CLICK_EVENT"
    });

}());