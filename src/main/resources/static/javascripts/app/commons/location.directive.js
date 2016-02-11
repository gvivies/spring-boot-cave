(function () {

    'use strict';

    function locationDirective(Constants, $mdDialog) {

        function LocationCtrl($scope) {

            var formVM = this;

            function close() {
                formVM.isVisibleMap = false;
                formVM.map = {};
                $scope.$emit(Constants.SHOW_MENU_EVENT);

            }

            function showLocation(event, item) {
                var lat = parseFloat(item.latitude),
                    lng = parseFloat(item.longitude),
                    center = {
                        latitude: lat,
                        longitude: lng
                    };

                formVM.map = {
                    center: center,
                    zoom: 12,
                    refresh: true
                };
                formVM.marker = {
                    id: 0,
                    coords: center,
                    title: item.name
                };

                formVM.title = 'Localisation de ' + item.name;
                formVM.isVisibleMap = true;
                $scope.$emit(Constants.HIDE_MENU_EVENT);

                google.maps.event.trigger(formVM.map, 'resize');
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