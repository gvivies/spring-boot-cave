//= require _modules
//= require_self

(function MainForm() {
    'use strict';

    function formService($mdDialog) {

        var service = {};
        /*
         * Function defining form
         */
        function showForm($scope, editedItem, settings) {
            $mdDialog.show({
                clickOutsideToClose: false,
                templateUrl: 'templates/' + settings.template,
                locals: {
                    item: editedItem,
                    size: settings.size,
                    scope: $scope,
                    uri: settings.uri,
                    lists: settings.lists
                },
                controllerAs: 'form',
                controller: 'DialogCtrl'
            });
        }

        service.showForm = showForm;

        return service;
    }

    /*
     * Controller managing dialog form
     */
    function DialogCtrl($scope, $mdDialog, locals, Constants, CrudService, UtilService) {

        var formVM = this;

        formVM.item = locals.item;
        formVM.size = locals.size;
        formVM.uri = locals.uri;
        formVM.lists = [];

        // Initializing all lists for select objects 
        if (locals.lists !== undefined) {
            locals.lists.forEach(function (itemList) {
                formVM.lists[itemList.name] = itemList.content;
            });
        }

        locals.scope.$emit(Constants.HIDE_MENU_EVENT);

        // --- Internal directive functions

        function onEditItemEventHandler(event, item) {
            formVM.item = item;
        }

        function onCreateSuccess(data) {
            formVM.item.id = data.id;
            locals.scope.$emit(Constants.CREATED_ITEM_EVENT, formVM.item);
            closeDialogHandler();
        }

        function onCreateError(response) {
            locals.scope.$emit(Constants.DISPLAY_MSG_EVENT, "Une erreur est survenue lors de la création : " + response.data.errors);
        }

        function onUpdateSuccess() {
            locals.scope.$emit(Constants.UPDATED_ITEM_EVENT, formVM.item);
            closeDialogHandler();
        }

        function onUpdateError(response) {
            locals.scope.$emit(Constants.DISPLAY_MSG_EVENT, "Une erreur est survenue lors de la modification : " + "\n" + response.data.errors);
        }

        // --- Available UI functions

        function closeDialogHandler() {
            locals.scope.$emit(Constants.SHOW_MENU_EVENT);
            $mdDialog.hide();
        }

        function saveHandler() {
            if (formVM.item.id !== undefined) {
                CrudService.resource(formVM.uri)
                    .update(formVM.item, onUpdateSuccess, onUpdateError);
            } else {
                CrudService.resource(formVM.uri)
                    .create(formVM.item, onCreateSuccess, onCreateError);
            }
        }

        // --- Attaching functions to view Model

        formVM.closeDialog = closeDialogHandler;
        formVM.cancel = closeDialogHandler;
        formVM.save = saveHandler;

        // --- Event handlers

        $scope.$on(Constants.EDIT_ITEM_EVENT, onEditItemEventHandler);
    }

    angular.module('form.service')
        .factory('FormService', ['$mdDialog', formService])
        .controller('DialogCtrl', ['$scope', '$mdDialog', 'locals', 'Constants', 'CrudService', 'UtilService', DialogCtrl]);
}());