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

                function openMenu($mdOpenMenu, ev) {
                    $mdOpenMenu(ev);
                };

                function selectMenu(idx) {
                    var menuTitle = 'Bienvenue sur ma cave personnelle',
                        nextUri;
                    if (idx === 1) {
                        menuTitle = 'Gérer les bouteilles';
                        nextUri = 'bottles';
                    } else if (idx === 2) {
                        menuTitle = 'Gérer les appellations';
                        nextUri = 'wines';
                    } else if (idx === 3) {
                        menuTitle = 'Gérer les régions';
                        nextUri = 'regions';
                    } else if (idx === 4) {
                        menuTitle = 'Gérer les domaines';
                        nextUri = 'wineries';
                    } else if (idx === 5) {
                        menuTitle = 'Gérer les classifications';
                        nextUri = 'classifications';
                    }
                    MenuService.setActive(idx);
                    menuVM.selectedMenuTitle = menuTitle;
                    $location.path(nextUri);
                };

                var menuVM = this;

                menuVM.menuLabel = ['Bouteilles', 'Appellations', 'Régions', 'Domaines', 'Classifications'];
                menuVM.openMenu = openMenu;
                menuVM.selectMenu = selectMenu;

                if (MenuService.getActive() == undefined) {
                    menuVM.selectedMenuTitle = 'Gérer les bouteilles';
                }
            },
            link: function (scope, element, attributes) {

            }
        };
    }

    angular.module('menu.directive')
        .directive('appMenu', menuDirective);
}());