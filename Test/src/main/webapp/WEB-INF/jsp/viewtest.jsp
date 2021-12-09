<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Test JSP</title>

<c:set var="ctx" value="<%=request.getContextPath()%>" />

<link href="${ctx}/js/css.css" type="text/css" rel="stylesheet">
<script src="${ctx}/js/angular.js" type="text/javascript"></script>
<script src="${ctx}/js/resource.js" type="text/javascript"></script>
<script src="${ctx}/js/controller.js" type="text/javascript" ></script>

</head>


<body>
<p>${ohyeah}</p>
	<div class="inputForm" ng-app="app" ng-controller="UserController">
		<div>
			<form class="inputForm" ng-model="info">
				<table id="inputTable">
					<tr>
						<td>
							<input type="text" name="id" ng-model="info.id" placeholder="ID" />
						</td>
					</tr>
					<tr>
						<td>
							<input type="password" name="pwd" ng-model="info.pwd" placeholder="Password" />
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" name="name" ng-model="info.name" placeholder="Name" />
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" name="gender" ng-model="info.gender" placeholder="Gender" />
						</td>
					</tr>
					<tr>
						<td>
							<input type="number" name="age" ng-model="info.age" placeholder="Age" />
						</td>
					</tr>
				</table>

				<input type="hidden" ng-model="newUserInfo.id" />
				<br>
				<div>
					<input type="button" value="검색" ng-click="getUser(info.id)" />
					<input type="button" value="저장" ng-click="createUser(info.id, info.pwd, info.name, info.gender, info.age)" />
					<input type="button" value="초기화" ng-click="reset(info)" />
				</div>
				<br>
			</form>
		</div>
		<table id="resultTable" border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>Password</th>
					<th>Name</th>
					<th>Gender</th>
					<th>Age</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="userInfo in users">
					<td>
						<span ng-bind="userInfo.id"></span>
						<!-- <input type="text" ng-model="userInfo.newUserInfo.id" ng-if="userInfo.show" placeholder=""> -->
					</td>
					<td>
						<span ng-bind="userInfo.pwd" ng-if="!userInfo.show"></span>
						<input type="text" ng-model="userInfo.newUserInfo.pwd" ng-if="userInfo.show">
					</td>
					<td>
						<span ng-bind="userInfo.name" ng-if="!userInfo.show"></span>
						<input type="text ng-model=" ng-model="userInfo.newUserInfo.name" ng-if="userInfo.show">
					</td>
					<td>
						<span ng-bind="userInfo.gender" ng-if="!userInfo.show"></span>
						<input type="text" ng-model="userInfo.newUserInfo.gender" ng-if="userInfo.show">
					</td>
					<td>
						<span ng-bind="userInfo.age" ng-if="!userInfo.show"></span>
						<input type="text" ng-model="userInfo.newUserInfo.age" ng-if="userInfo.show">
					</td>
					<td>
						<input type="button" ng-if="!userInfo.show" ng-click="click(userInfo)" value="수정">
						<input type="button" ng-if="userInfo.show"
							ng-click="updateUser(userInfo, userInfo.id, userInfo.newUserInfo.pwd, userInfo.newUserInfo.name, userInfo.newUserInfo.gender, userInfo.newUserInfo.age)"
							value="저장"
						>

						<input type="button" ng-if="!userInfo.show" ng-click="deleteUser1(userInfo.id)" value="삭제">
						<input type="button" ng-if="userInfo.show" ng-click="click(userInfo)" value="뒤로가기">

					</td>
				</tr>
				<tr ng-if="users == null || users.length == 0">
					<td colspan="6">no data</td>
				</tr>

			</tbody> 	

		</table>
	</div>
</body>
</html>