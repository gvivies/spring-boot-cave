//= require_tree commons
//= require_self

(function RegionController() {

    'use strict';


    angular.module('regions.controller', [])
        .controller('RegionsCtrl', RegionsCtrl);

    RegionsCtrl.$inject = ['CrudService', 'UtilService', 'Constants', '$scope', '$mdDialog', 'FormService', 'ConfirmService'];

    function RegionsCtrl(CrudService, UtilService, Constants, $scope, $mdDialog, FormService, ConfirmService) {

        var viewModel = this;

        // --- Handler functions 

        function createItemHandler() {
            FormService.showForm($scope, {}, viewModel.formSettings);
        }

        function editItemHandler(item) {
            FormService.showForm($scope, UtilService.clone(item), viewModel.formSettings);
        }

        function deleteItemHandler(item) {

            function removeItem() {

                function onRemoveError() {
                    $scope.$emit(Constants.DISPLAY_MSG_EVENT, "Une erreur est survenue lors de la suppression de " + item.name);
                }

                function onRemoveSuccess() {
                    var itemList = $scope.ctrl.items,
                        idx = itemList.indexOf(item);
                    itemList.splice(idx, 1);
                    $scope.$emit(Constants.DISPLAY_MSG_EVENT, "La suppression de " + item.name + " a été effectuée avec succès");
                }

                CrudService.resource(Constants.REGIONS_URI + '/' + item.id)
                    .remove(onRemoveSuccess, onRemoveError);
            }

            ConfirmService.confirmDelete(item, 'la région')
                .then(removeItem);
        }

        function onCreatedItemEventHandler(event, item) {
            viewModel.items.push(item);
            $scope.$emit(Constants.DISPLAY_MSG_EVENT, "La région " + item.name + " a été créée avec succès");
        }

        function onUpdatedItemEventHandler(event, item) {
            var idx = UtilService.getIndex(item.id, viewModel.items);
            if (idx >= 0) {
                viewModel.items[idx] = item;
            }
            $scope.$emit(Constants.DISPLAY_MSG_EVENT, "La région " + item.name + " a été modifiée avec succès");
        }

        // --- Attaching functions and events handler

        viewModel.createItem = createItemHandler;
        viewModel.editItem = editItemHandler;
        viewModel.deleteItem = deleteItemHandler;

        $scope.$on(Constants.CREATED_ITEM_EVENT, onCreatedItemEventHandler);
        $scope.$on(Constants.UPDATED_ITEM_EVENT, onUpdatedItemEventHandler);

        // --- On load

        viewModel.items = CrudService.resource(Constants.REGIONS_URI).list();
        viewModel.formSettings = {
            size: "medium",
            template: "region.html",
            uri: Constants.REGIONS_URI
        };
        $scope.$emit(Constants.SHOW_MENU_EVENT);
    }

}());