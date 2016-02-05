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
            controller: function ($scope, $attrs, $location, MenuService, Constants) {

                function onShowMenuEventHandler() {
                    menuVM.displayMenu = true;
                }

                function onHideMenuEventHandler() {
                    menuVM.displayMenu = false;
                }

                function openMenu($mdOpenMenu, ev) {
                    $mdOpenMenu(ev);
                }

                function selectMenu(idx) {
                    var menuTitle = 'Bienvenue sur ma cave personnelle',
                        nextUri;
                    if (idx === 1) {
                        menuTitle = 'Les bouteilles';
                        nextUri = 'bottles';
                    } else if (idx === 2) {
                        menuTitle = 'Les appellations';
                        nextUri = 'wines';
                    } else if (idx === 3) {
                        menuTitle = 'Les régions';
                        nextUri = 'regions';
                    } else if (idx === 4) {
                        menuTitle = 'Les domaines';
                        nextUri = 'wineries';
                    } else if (idx === 5) {
                        menuTitle = 'Les types';
                        nextUri = 'classifications';
                    }
                    $location.path(nextUri);
                    MenuService.setActive(idx, menuTitle);
                }

                var menuVM = this;

                menuVM.menuLabel = ['Bouteilles', 'Appellations', 'Régions', 'Domaines', 'Types'];
                menuVM.openMenu = openMenu;
                menuVM.selectMenu = selectMenu;

                $scope.$on(Constants.SHOW_MENU_EVENT, onShowMenuEventHandler);
                $scope.$on(Constants.HIDE_MENU_EVENT, onHideMenuEventHandler);

            },
            link: function (scope, element, attributes) {

            }
        };
    }

    angular.module('menu.directive')
        .directive('appMenu', menuDirective);
}());