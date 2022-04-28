var app = angular.module('app', ['ngResource']);

app.controller('UserController', function($scope, $resource) {

	let res = $resource(
		"/users/:val",
		null,
		{
			getUser: {
				method: 'GET',
				params: { val: "" }
			},

			createUser: {
				method: 'POST'
			},

			updateUser: {
				method: 'PATCH',
				params: { val: "" }
			},

			delete: {
				method: 'DELETE',
				params: { val: "" }
			}
		}
	);



	getUsers = function() {
		res.query().$promise.then(function(users) {
			$scope.users = users;
		});
	};
	getUsers();


	$scope.getUser = function(id) {
		res.getUser(
			{ 
				val: id,
				"name":"",
				"id":""
			 }
			, null
			, function(users) {
				$scope.users = users;
			}
			, function() {
				getUsers();
				alert("존재하지 않습니다.");
			}
		)
	};

	$scope.deleteUser1 = function(id) {
		res.delete(
			{ val: id }
			, null
			, function() {
				getUsers();
			}
		)
	};

	$scope.createUser = function(id, pwd, name, gender, age) {
		res.createUser(
			{}
			, {
				id: id,
				pwd: pwd,
				name: name,
				gender: gender,
				age: age
			}
			, function() {
				getUsers();
			}
			, function() {
				alert("올바르게 입력해주세요");
			}
		)
	};

	$scope.updateUser = function(user, id, pwd, name, gender, age) {

		res.updateUser(
			{ val: id }
			, {
				pwd: pwd,
				name: name,
				gender: gender,
				age: age
			}
			, function() {
				getUsers();
				click(user);
			}
			, function() {
				alert("올바른 ID를 입력해주세요");
			}
		)
	};

	$scope.click = function(user) {
		user.show = !user.show;
		user.newUserInfo = angular.copy(user);
	};

	$scope.reset = function(info) {
		getUsers();
		info.id = "";
		info.pwd = "";
		info.name = "";
		info.gender = "";
		info.age = "";

	}

});