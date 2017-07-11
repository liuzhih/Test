var formCtrl = function($scope, $http, $state) {
	


	$scope.regist = function() {
		$http({
			url : 'regist.do',
			method : 'POST',
			params : {
				uAccount : $scope.userInfo.email,
				uPwd : $scope.userInfo.password
			}
		}).success(function() {
			alert('注册成功！');
			$state.go("login");

		}).error(function() {

		})
	};
	$scope.login = function() {
		$http({
			url : 'login.do',
			method : 'POST',
			params : {
				uAccount : $scope.userInfo.email,
				uPwd : $scope.userInfo.password,
				code : document.getElementById("checkCode").value,
				validate : $scope.validate
			}
		}).success(function(date) {
			if(date){
				$scope.books = date;
				$state.go('booklist',{bookType:0});
			}else{
				alert("验证码不对");
			}
			
			
			
		}).error(function() {
			console.log("error");
			
		})
	};
};


