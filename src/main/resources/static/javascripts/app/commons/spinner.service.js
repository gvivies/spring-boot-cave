/* Interceptor pour affichage du spinner */



//= require _modules
//= require_self

(function () {
    'use strict';

    function configuration($httpProvider, $rootScope) {
        $httpProvider.responseInterceptors.push('httpInterceptorService');
        $httpProvider.defaults.transformRequest.push(spinnerFunction);
    }

    function spinnerService($q, $rootScope) {
        return {
            'request': function (config) {
                $rootScope.loading = false;
                return config;
            },
            'requestError': function (rejection) {
                $rootScope.loading = false;
                if (canRecover(rejection)) {
                    return responseOrNewPromise;
                }
                return $q.reject(rejection);
            },
            'response': function (response) {
                $rootScope.loading = false;
                return response;
            },
            'responseError': function (rejection) {
                $rootScope.loading = false;
                if (canRecover(rejection)) {
                    return responseOrNewPromise;
                }
                return $q.reject(rejection);
            }
        };
    }

    angular.module('spinner.service')
        .config(function ($httpProvider) {
            //$httpProvider.responseInterceptors.push('httpInterceptorService');
            //$httpProvider.defaults.transformRequest.push(spinnerFunction);
        })
        .factory('httpInterceptorService', ['$q', '$rootScope', function spinnerFunction(data, headersGetter) {
            $rootScope.loading = true;
            return data;
    }]);
}());