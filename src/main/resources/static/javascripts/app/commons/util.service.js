//= require _modules
//= require_self

(function () {
    'use strict';

    function UtilService() {

        function fnClone(obj) {
            var target = {},
                property;
            for (property in obj) {
                if (obj.hasOwnProperty(property)) {
                    target[property] = obj[property];
                }
            }
            return target;
        }

        function getIndex(id, items) {
            var idx, item;
            for (idx = 0; idx < items.length; idx++) {
                if (items[idx].id === id) {
                    return idx;
                }
            }
            return -1;
        }

        this.clone = fnClone;
        this.getIndex = getIndex;
    }


    angular.module('util.service')
        .service('UtilService', UtilService);
})();