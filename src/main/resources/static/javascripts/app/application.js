//= require_tree lib
//= require_tree commons
//= require_tree region
//= require_tree winery
//= require_self

(function () {
    'use strict';
    var
    // 'Authorization' = 'x-auth-token',
    //the HTTP headers to be used by all requests
        httpHeaders,
        //the message to be shown to the user
        message;

    function ConfigureApp($routeProvider, $mdThemingProvider, $locationProvider, $httpProvider) {

        // --- Routing

        $routeProvider
            .when('/regions', {
                templateUrl: 'templates/regions.html',
                controller: 'RegionsCtrl',
                controllerAs: 'ctrl'
            })
            .when('/wines', {
                templateUrl: 'templates/wines.html',
                controller: 'WinesCtrl',
                controllerAs: 'ctrl'
            })
            .when('/wineries', {
                templateUrl: 'templates/wineries.html',
                controller: 'WineriesCtrl',
                controllerAs: 'ctrl'
            })
            .when('/classifications', {
                templateUrl: 'templates/classifications.html',
                controller: 'ClassificationsCtrl',
                controllerAs: 'ctrl'
            })
            .when('/bottles', {
                templateUrl: 'templates/bottles.html',
                controller: 'BottlesCtrl',
                controllerAs: 'ctrl'
            })
            .when('/stats', {
                templateUrl: 'templates/statistics.html',
                controller: 'StatsCtrl',
                controllerAs: 'ctrl'
            }).otherwise({
                redirectTo: '/bottles'
            });

        $mdThemingProvider.theme('default')
            .primaryPalette('indigo').accentPalette('grey');

        $locationProvider.html5Mode(false);

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';


    }

    angular.module('cave', ['ngRoute',
                            'ngMaterial',
                            'chart.js',
                            'menu.directive',
                            'message.directive',
                            'menu.service',
                            'crud.service',
                            'util.service',
                            'form.service',
                            'confirm.service',
                            'login.controller',
                            'regions.controller',
                            'bottles.controller',
                            'wines.controller',
                            'classifications.controller',
                            'wineries.controller',
                            'stats.controller',
                            'geocode.service',
                            'location.directive',
                            'spinner.directive'])
        .config(['$routeProvider', '$mdThemingProvider', '$locationProvider', '$httpProvider', ConfigureApp])

    .run(function ($rootScope, Constants) {
        $rootScope.$broadcast(Constants.SHOW_MENU_EVENT);

    });
}());