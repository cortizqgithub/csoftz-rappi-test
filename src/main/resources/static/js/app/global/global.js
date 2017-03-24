/*
Date:     Jan.10/2016
Modified: Jun.17/2016
 */
var hostBase = "http://carlosortiz:8081/"
var apiRefBase = "schema/api/v1";
var version = "1.0.0.30";
var idTablesContent = "tablesContent";
var idViewsContent = "viewsContent";
var idProceduresContent = "proceduresContent";
var idFunctionsContent = "functionsContent";
var idSearchForTables = "searchForTables"
var idSearchForViews = "searchForViews";
var idSearchForProcedures="searchForProcedures";
var idSearchForFunctions="searchForFunctions";
var idSchemaName = "schemaName";
var idSchemaNameOwner = "schemaNameOwner";
var idResourceKind = "resourceKind";
var idResourceName = "resourceName";
var idSchemaSynchronize = "schemaSynchronize";
var schemaName = "";
var schemaNameOwner = "";
var resourceKind = "";
var resourceName = "";

toastr.options = {
	"closeButton" : true,
	"debug" : false,
	"newestOnTop" : true,
	"progressBar" : true,
	"positionClass" : "toast-top-full-width",
	"preventDuplicates" : true,
	"onclick" : null,
	"showDuration" : "300",
	"hideDuration" : "1000",
	"timeOut" : "5000",
	"extendedTimeOut" : "1000",
	"showEasing" : "swing",
	"hideEasing" : "linear",
	"showMethod" : "fadeIn",
	"hideMethod" : "fadeOut"
}