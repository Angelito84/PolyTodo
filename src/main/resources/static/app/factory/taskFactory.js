polytoDo.factory('taskFactory', ['$http', function($http) {
    var factory = {};

    factory.getLoggedUser = function (callback) {
        $http({
            method: 'GET',
            url: '/loggedUser'
        }).then(function successCallback(response) {
            callback(response)
        }, function errorCallback(err) {
            console.log('Error: ' + err.data.error);
        });
    };

    factory.getTaskSet = function (callback) {
        $http({
            method: 'GET',
            url: '/tasks'
        }).then(function successCallback(response) {
            callback(response)
        }, function errorCallback(err) {
            console.log('Error: ' + err.data.error);
        });
    };

    factory.addTask = function (task, callback) {
        $http({
            method: 'POST',
            url: '/addTask',
            data: task
        }).then(function successCallback(response) {
            callback(response);
        }, function errorCallback(err) {
            console.log('Error: ' + err.data.error);
        });
    };

    factory.doneTask= function (task, callback) {
        $http({
            method: 'PUT',
            url: '/doneTask',
            data: task
        }).then(function successCallback(response) {
            callback(response);
        }, function errorCallback(err) {
            console.log('Error: ' + err.data.error);
        });
    };

    factory.editTask = function (task, callback) {
        $http({
            method: 'PUT',
            url: '/editTask',
            data: task
        }).then(function successCallback(response) {
            callback(response);
        }, function errorCallback(err) {
            console.log('Error: ' + err.data.error);
        });
    };

    factory.deleteTask = function (id, callback) {
        $http({
            method: 'DELETE',
            url: '/deleteTask/' + id,
        }).then(function successCallback(response) {
            callback(response);
        }, function errorCallback(err) {
            console.log('Error: ' + err.data.error);
        });
    };

    return factory;
}]);