//= require _modules
//= require_self

(function () {
    'use strict';

    function menuService($rootScope) {

        var menuItem = "",
            service = {};

        service.getActive = function getActive() {
            return this.menuItem;
        };

        service.setActive = function setActive(value) {
            this.menuItem = value;
            this.broadcastMenuSelectedEvent();
        };

        service.broadcastMenuSelectedEvent = function broadcastMenuSelectedEvent() {
            $rootScope.$broadcast('MenuSelectedEvent');
        };

        return service;
    }

    angular.module('menu.service')
        .factory('MenuService', menuService);

}());