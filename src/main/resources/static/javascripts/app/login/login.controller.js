(function () {
    'use strict';

    function LoginCtrl($location, $rootScope, $http) {

        var viewModel = this;

        function authenticate(user, callback) {
            var headers = user ? {
                authorization: "Basic " + //
                    btoa(user.name + ":" + //
                        user.password)
            } : {};

            $http.get('user', {
                    headers: headers
                })
                .success(function (data) {
                    if (data.name) {
                        $rootScope.authenticated = true;
                    } else {
                        $rootScope.authenticated = false;
                    }
                    callback && callback();
                }).error(function () {
                    $rootScope.authenticated = false;
                    callback && callback();
                });

        }

        function onAuthentication() {
            if ($rootScope.authenticated) {
                $location.path('bottles');
                viewModel.error = false;
            } else {
                $location.path("/login");
                viewModel.error = true;
            }
        }

        function login() {
            authenticate(viewModel.user, onAuthentication);
        }

        viewModel.login = login;
    }

    LoginCtrl.$inject = ['$location', '$rootScope', '$http'];

    angular.module('login.controller', [])
        .controller('LoginCtrl', LoginCtrl);

}());