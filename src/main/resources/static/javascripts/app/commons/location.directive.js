(function () {

    'use strict';

    function locationDirective(Constants, $mdDialog) {

        function LocationCtrl($scope) {

            var formVM = this;

            function close() {
                formVM.isVisibleMap = false;
                $scope.$emit(Constants.SHOW_MENU_EVENT);

            }

            function showLocation(event, item) {
                $scope.$emit(Constants.HIDE_MENU_EVENT);
                formVM.isVisibleMap = true;
                formVM.map = {
                    center: {
                        latitude: parseFloat(item.latitude),
                        longitude: parseFloat(item.longitude)
                    },
                    zoom: 12
                };
                formVM.marker = {
                    id: 0,
                    coords: {
                        latitude: parseFloat(item.latitude),
                        longitude: parseFloat(item.longitude)
                    }
                };
                formVM.title = 'Localisation de ' + item.name;
            }

            formVM.close = close;
            formVM.map = {};
            formVM.isVisibleMap = false;
            $scope.$on(Constants.SHOW_LOCATION_EVENT, showLocation);

        }

        return {
            restrict: 'A',
            replace: true,
            templateUrl: 'templates/location.html',
            controllerAs: 'form',
            controller: LocationCtrl
        };
    }

    angular.module('location.directive', ['uiGmapgoogle-maps'])
        .directive('location', ['Constants', '$mdDialog', locationDirective]);
}());