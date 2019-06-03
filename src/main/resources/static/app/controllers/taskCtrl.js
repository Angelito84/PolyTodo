polytoDo.controller('taskCtrl', ['$http', '$scope','taskFactory', function ($http, $scope, taskFactory) {
    $scope.getLoggedUser = function () {
        taskFactory.getLoggedUser(function (response) {
            $scope.user = response.data;
        });
    };

    $scope.refreshSet = function () {
        taskFactory.getTaskSet(function (response) {
            $scope.tasks = response.data;
        });
    };

    $scope.addTask = function (content) {
        $scope.nameTask=""
        var task = {
            content: content
        };
        taskFactory.addTask(task, function (response) {
            $scope.refreshSet();
        });
    };

    $scope.doneTask = function (task) {
        taskFactory.doneTask(task, function (response) {
            $scope.refreshSet();
        });
    };

    $scope.editTask = function (task) {
        taskFactory.editTask(task, function (response) {
            $scope.refreshSet();
        });
    };

    $scope.deleteTask = function (id) {
        taskFactory.deleteTask(id, function (response) {
            $scope.refreshSet();
        });
    };
}]);