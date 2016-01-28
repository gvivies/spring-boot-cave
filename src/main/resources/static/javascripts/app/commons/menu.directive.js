//= require _modules
//= require_self

(function () {
    'use strict';

    function menuDirective() {
        return {
            restrict: 'A',
            replace: true,
            templateUrl: 'templates/menu.html',
            controllerAs: 'menuCtrl',
            controller: function ($scope, $attrs, $location, MenuService) {

                this.menuLabel = ['Bouteilles', 'Vins', 'Régions', 'Domaines', 'Classifications'];
                this.selectedMenuTitle = 'Gérer les bouteilles';
                this.openMenu = function ($mdOpenMenu, ev) {
                    $mdOpenMenu(ev);
                };

                this.selectMenu = function (idx) {
                    var menuTitle = 'Bienvenue sur ma cave personnelle';
                    if (idx === 1) {
                        menuTitle = 'Gérer les bouteilles';
                        $location.path('bottles');
                    } else if (idx === 2) {
                        menuTitle = 'Gérer les vins';
                        $location.path('wines');
                    } else if (idx === 3) {
                        menuTitle = 'Gérer les régions';
                        $location.path('regions');
                    } else if (idx === 4) {
                        menuTitle = 'Gérer les domaines';
                        $location.path('wineries');
                    } else if (idx === 5) {
                        menuTitle = 'Gérer les classifications';
                        $location.path('classifications');
                    }
                    MenuService.setActive(idx);
                    this.selectedMenuTitle = menuTitle;
                };
            },
            link: function (scope, element, attributes) {

            }
        };
    }

    angular.module('menu.directive')
        .directive('appMenu', menuDirective);
}());