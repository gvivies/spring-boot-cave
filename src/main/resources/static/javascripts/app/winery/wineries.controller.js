//=require_self

(function () {

    'use strict';

    angular.module('wineries.controller', [])
        .controller('WineriesCtrl', WineriesCtrl);

    WineriesCtrl.$inject = ['$scope', 'CrudService', 'Constants', 'FormService', 'UtilService', '$mdDialog', 'ConfirmService'];

    function WineriesCtrl($scope, CrudService, Constants, FormService, UtilService, $mdDialog, ConfirmService) {

        var viewModel = this;

        // --- Handler functions 
        function onShowMenuEventHandler() {
            viewModel.displayMenu = true;
        }

        function onHideMenuEventHandler() {
            viewModel.displayMenu = false;
        }

        function createItemHandler() {
            FormService.showForm($scope, {}, viewModel.formSettings);
        }

        function editItemHandler(item) {
            FormService.showForm($scope, UtilService.clone(item), viewModel.formSettings);
        }

        function onCreatedItemEventHandler(event, item) {
            viewModel.items.push(item);
            $scope.$emit(Constants.DISPLAY_MSG_EVENT, "Le domaine " + item.name + " a été créé avec succès");
        }

        function onUpdatedItemEventHandler(event, item) {
            var idx = UtilService.getIndex(item.id, viewModel.items);
            if (idx >= 0) {
                viewModel.items[idx] = item;
            }
            $scope.$emit(Constants.DISPLAY_MSG_EVENT, "Le domaine " + item.name + " a été modifié avec succès");
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

                CrudService.resource(Constants.WINERIES_URI + '/' + item.id)
                    .remove(onRemoveSuccess, onRemoveError);
            }

            ConfirmService.confirmDelete(item, 'le domaine')
                .then(removeItem);
        }

        // --- Attaching functions and events handler

        viewModel.editItem = editItemHandler;
        viewModel.createItem = createItemHandler;
        viewModel.deleteItem = deleteItemHandler;

        $scope.$on(Constants.CREATED_ITEM_EVENT, onCreatedItemEventHandler);
        $scope.$on(Constants.UPDATED_ITEM_EVENT, onUpdatedItemEventHandler);
        $scope.$on(Constants.SHOW_MENU_EVENT, onShowMenuEventHandler);
        $scope.$on(Constants.HIDE_MENU_EVENT, onHideMenuEventHandler);

        // --- On load

        viewModel.items = CrudService.resource(Constants.WINERIES_URI).list();
        viewModel.formSettings = {
            size: "xxl",
            template: "winery.html",
            uri: Constants.WINERIES_URI
        };
        $scope.$emit(Constants.SHOW_MENU_EVENT);

    }

}());