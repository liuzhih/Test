var bookFormCtrl = function($scope, $http, $state) {

	$scope.addMyBook = function() {

		$http({
			url : 'addBook.do',
			method : 'POST',
			params : {
				bName : $scope.add_bookName,
				bType : $scope.add_bookType,
				time : $scope.add_bookDate,
				bAuthor : $scope.add_bookAuthor,
				bPrice : $scope.add_bookPrice,
			}
		}).success(function() {
			alert('添加成功！');
			$state.go('booklist', {
				bookType : 0
			});

		}).error(function() {
			alert('添加失败！');
		})

	};

	$scope.updateBook = function(book) {

		$state.go("updatebook", {
			id : book.bId
		});

	};
	$scope.bookDetail = function(book) {
		$state.go("bookdetail", {
			bookId : book.bId
		});
	};

};

var BookDetailCtrl = function($scope, $http, $state, $stateParams, $filter) {

	$http({
		url : 'findBookById.do',
		method : 'GET',
		params : {
			bId : $stateParams.bookId

		}
	}).success(function(date) {

		$state.go("bookdetail");
		$scope.dbook = date;
		// $scope.ud_bookType = date.bType;
		// $scope.ud_bookDate = $filter('date')(date.bDate, 'yyyy-MM-dd');
		// $scope.ud_bookAuthor = date.bAuthor;
		// $scope.ud_bookPrice = date.bPrice;
	}).error(function() {

	})
}

var updateBookCtrl = function($scope, $http, $state, $stateParams, $filter) {

	$http({
		url : 'findBookById.do',
		method : 'GET',
		params : {
			bId : $stateParams.id

		}
	}).success(function(date) {

		$state.go("updatebook");
		$scope.ud_bookName = date.bName;
		$scope.ud_bookType = date.bType;
		$scope.ud_bookDate = $filter('date')(date.bDate, 'yyyy-MM-dd');

		/*
		 * $filter('date.bDate')($scope.ud_bookDate,'yyyy-MM-dd');
		 */
		$scope.ud_bookAuthor = date.bAuthor;
		$scope.ud_bookPrice = date.bPrice;
	}).error(function() {

	})
	$scope.doUpdateBook = function() {

		$http({
			url : 'updateBook.do',
			method : 'POST',
			params : {
				time : $scope.ud_bookDate,
				bId : $stateParams.id,
				bName : $scope.ud_bookName,
				bType : $scope.ud_bookType,

				bAuthor : $scope.ud_bookAuthor,
				bPrice : $scope.ud_bookPrice

			}
		}).success(function() {
			alert("修改成功");
			$state.go('booklist', {
				bookType : 0
			});
		}).error(function() {
			alert("失败");
		})
	};
	$scope.deleteBook = function() {
		$http({
			url : 'deleteBook.do',
			method : 'GET',
			params : {
				bId : $stateParams.id,

			}
		}).success(function() {
			alert("删除成功");
			$state.go('booklist', {
				bookType : 0
			});
		}).error(function() {
			alert("失败");
		})
	};
};

var queryAllBook = function($scope, $http, $state, $stateParams) {

	$http({
		url : 'queryBook.do',
		method : 'POST',
		params : {
		// bType : $stateParams.type
		}
	}).success(function(date) {

		$scope.books = date;
		// alert(books[0].bName);
	}).error(function() {

	})

	$scope.typeQuery = function(type) {

		$http({
			url : 'queryTypeBook.do',
			method : 'POST',
			params : {
				bType : type
			}
		}).success(function(date) {

			$scope.books = date;
			// alert(books[0].bName);
		}).error(function() {

		})
	};

	$scope.queryAllBook	 = function(type) {

		$http({
			url : 'queryBook.do',
			method : 'POST',
			params : {
			// bType : $stateParams.type
			}
		}).success(function(date) {

			$scope.books = date;
			// alert(books[0].bName);
		}).error(function() {

		});
	};
};