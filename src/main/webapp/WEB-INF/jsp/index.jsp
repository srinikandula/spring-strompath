<!DOCTYPE html>
<html lang="en" ng-app="beaconApp">
<head>
    <meta charset="UTF-8">
    <title>Get Well Admin Portal</title>

    <script type="text/javascript" src="//maps.googleapis.com/maps/api/js?libraries=places"></script>

    <script src="lib/underscore-min-1.5.2.js"></script>
    <script src="bower_components/ng-file-upload/angular-file-upload-shim.min.js"></script>
    <script src="bower_components/angular/angular.min.js"></script>
    <script src="bower_components/ng-file-upload/angular-file-upload.min.js"></script>
    <script src="bower_components/angular-route/angular-route.min.js"></script>
    <script src="bower_components/angular-animate/angular-animate.min.js"></script>
    <script src="bower_components/angular-touch/angular-touch.min.js"></script>
    <script src="bower_components/angular-strap/dist/angular-strap.min.js"></script>
    <script src="bower_components/angular-strap/dist/angular-strap.tpl.min.js"></script>
    <script src="bower_components/ng-table/ng-table.min.js"></script>
    <script src="bower_components/jquery/dist/jquery.js"></script>
    <script src="bower_components/angular-unsavedChanges/dist/unsavedChanges.js"></script>
    <script src="bower_components/spin.js/spin.js"></script>
    <script src="bower_components/angular-spinner/angular-spinner.js"></script>
    <script src="lib/ui-bootstrap-tpls-0.11.0.min.js"></script>
    <script src="lib/async.js"></script>
    <script src="js/ngBeaconApp.js"></script>
    <script src="js/services/userManager.js"></script>
    <script src="js/services/appConfigManager.js"></script>
    <script src="js/services/categoriesManager.js"></script>
    <script src="js/services/classificationsManager.js"></script>
    <script src="js/services/appUtils.js"></script>
    <script src="js/services/businessNavHelper.js"></script>
    <script src="js/services/geocoderService.js"></script>
    <script src="js/services/googlePlacesService.js"></script>
    <script src="js/services/citiesAndNeighborhoodsManager.js"></script>
    <script src="js/services/infoOverlayService.js"></script>
    <script src="js/directives/ng-really.js"></script>
    <script src="js/directives/stateOptions.js"></script>
    <script src="js/filters/unsafeFilter.js"></script>
    <script src="js/filters/arrayNoneFilter.js"></script>
    <script src="js/providers/stateValueProvider.js"></script>
    <script src="js/controllers/homeController.js"></script>
    <script src="js/controllers/conditionController.js"></script>
    <script src="js/controllers/procedureController.js"></script>
    <script src="js/controllers/neighborhoodsController.js"></script>
    <script src="js/controllers/beaconController.js"></script>
    <script src="js/controllers/businessController.js"></script>
    <script src="js/controllers/businessImportController.js"></script>
    <script src="js/controllers/apiDocsController.js"></script>
    <script src="js/controllers/accountController.js"></script>
    <script src="js/controllers/categoriesController.js"></script>
    <script src="js/controllers/usersController.js"></script>



    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.css">
    <link rel="stylesheet" href="bower_components/ng-table/ng-table.css">
    <link rel="stylesheet" href="css/app.css">

</head>
<body>
<!-- Fixed navbar -->
<div class="navbar navbar-inverse navbar-default navbar-fixed-top" role="navigation" bs-navbar>
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li data-match-route="/$"><a href="#">Home</a></li>
                <li data-match-route="/conditions" ng-if="appConfigManager.areConditionsEnabled()"><a href="#/conditions">Conditions</a></li>
                <li data-match-route="/procedures" ng-if="appConfigManager.areProceduresEnabled()"><a href="#/procedures">Procedures</a></li>
                <li data-match-route="/categories" ng-if="userManager.isAdmin()"><a href="#/categories">Categories</a></li>
                <li data-match-route="/neighborhoods" ng-if="userManager.isAdmin()"><a href="#/cities">Cities</a></li>
                <li data-match-route="/businesses" ng-if="userManager.canViewBusinesses()" class="dropdown">
                    <a href="#/businesses" class="dropdown-toggle" data-toggle="dropdown">Businesses <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#/businesses" ng-if="userManager.canViewBusinesses()">View All</a></li>
                        <li><a href="#/businesses-new" ng-if="userManager.isAuthor() || userManager.isPublisher() || userManager.isAdmin()">Add New</a></li>
                        <li><a href="#/businesses-import-google" ng-if="userManager.isAuthor() || userManager.isPublisher() || userManager.isAdmin()">Google Places - Import</a></li>
                        <li><a href="#/businesses-missing-fields" ng-if="userManager.isPublisher() || userManager.isAdmin()">Missing Fields Report</a></li>
                    </ul>
                </li>
                <li data-match-route="/resolveBusinesses" ng-if="userManager.canViewBusinesses()">
                    <a href="#/resolveBusinesses" class="dropdown-toggle" data-toggle="dropdown">Resolve Businesses </a>
                </li>
                <form class="navbar-form navbar-left" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search" ng-model="poiSearchText">
                    </div>
                    <button type="button" class="btn btn-default btn-sm" ng-click="searchPOIs()">Submit</button>
                </form>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li data-match-route="/user" ng-if="userManager.isAdmin()"><a href="#/users">Users</a></li>
                <li data-match-route="/docs" ng-if="userManager.canViewAPIDocs()"><a href="#/docs">API Docs</a></li>
                <li data-match-route="/account"><a href="#/account">Account</a></li>
                <li><a href="/logout">Logout</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>

</div>

<div class="container">
    <div class="view-container">
        <div ng-view class="view-frame"></div>
    </div>
</div>

</body>
</html>