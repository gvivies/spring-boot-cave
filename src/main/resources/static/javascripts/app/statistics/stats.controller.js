//=require_self

(function () {

    'use strict';


    angular.module('stats.controller', [])
        .controller('StatsCtrl', StatsCtrl);

    StatsCtrl.$inject = ['$scope', '$rootScope', 'CrudService', 'Constants'];

    function StatsCtrl($scope, $rootScope, CrudService, Constants) {

        var viewModel = this;

        // on Load
        viewModel.labels = [];
        viewModel.data = [];

        CrudService.resource(Constants.REGIONS_URI + "/withcount").list(function onSuccess(response) {
            var idx, item;
            for (idx = 0; idx < response.length; idx++) {
                item = response[idx];
                viewModel.labels.push(item.name);
                viewModel.data.push(item.quantity);
            }
        });


        $rootScope.addItemElement = false;
        $scope.$broadcast(Constants.SHOW_MENU_EVENT);

    }


}());