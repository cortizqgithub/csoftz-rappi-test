/*
Date:     Jan.10/2016
Modified: Feb.01/2016
 */

/* Events */
/* Methods for event handlers follows */
var onSearchForTablesKeyup = function(event) {
	console.log('onSearchForTablesKeyup fired');

	var resourceData = $('#' + idSearchForTables).val();
	console.log('KEYUP resourceData=[' + resourceData + ']');
	if (resourceData === '') {
		retrieveSchemaTables(schemaName, schemaNameOwner);
	} else {
		searchSchemaIndexTables(schemaName, schemaNameOwner, resourceData);
	}
};
var onSearchForTablesEventHandler = function($e, datum) {
	console.log('onSearchForTablesEventHandler fired');

	var resourceData = getResourceNameWith(idSearchForTables, datum);
	console.log('CURSORCHANGE datum=[' + resourceData + ']');
	// searchSchemaIndexTables(schemaName, schemaNameOwner, resourceData);
};
var onSearchForViewsKeyup = function(event) {
	console.log('onSearchForViewsKeyup fired');

	var resourceData = $('#' + idSearchForViews).val();
	console.log('KEYUP resourceData=[' + resourceData + ']');
	if (resourceData === '') {
		retrieveSchemaViews(schemaName, schemaNameOwner);
	} else {
		searchSchemaIndexViews(schemaName, schemaNameOwner, resourceData);
	}
};
var onSearchForViewsEventHandler = function($e, datum) {
	console.log('onSearchForTablesEventHandler fired');

	var resourceData = getResourceNameWith(idSearchForViews, datum);
	console.log('CURSORCHANGE datum=[' + resourceData + ']');
};
var onSearchForProceduresKeyup = function(event) {
	console.log('onSearchForProceduresKeyup fired');

	var resourceData = $('#' + idSearchForProcedures).val();
	console.log('KEYUP resourceData=[' + resourceData + ']');
	if (resourceData === '') {
		retrieveSchemaProcedures(schemaName, schemaNameOwner);
	} else {
		searchSchemaIndexProcedures(schemaName, schemaNameOwner, resourceData);
	}
};
var onSearchForProceduresEventHandler = function($e, datum) {
	console.log('onSearchForTablesEventHandler fired');

	var resourceData = getResourceNameWith(idSearchForProcedures, datum);
	console.log('CURSORCHANGE datum=[' + resourceData + ']');
};
var onSearchForFunctionsKeyup = function(event) {
	console.log('onSearchForFunctionsKeyup fired');

	var resourceData = $('#' + idSearchForFunctions).val();
	console.log('KEYUP resourceData=[' + resourceData + ']');
	if (resourceData === '') {
		retrieveSchemaFunctions(schemaName, schemaNameOwner);
	} else {
		searchSchemaIndexFunctions(schemaName, schemaNameOwner, resourceData);
	}
};
var onSearchForFunctionsEventHandler = function($e, datum) {
	console.log('onSearchForTablesEventHandler fired');

	var resourceData = getResourceNameWith(idSearchForFunctions, datum);
	console.log('CURSORCHANGE datum=[' + resourceData + ']');
};

/* Common methods */
var getResourceNameWith = function(id, datum) {
	var rslt = '';
	if (typeof datum != 'undefined') {
		rslt = datum.name;
	} else {
		rslt = $('#' + id).val();
	}
	return rslt;
};
var createHREFLink = function(schemaName, schemaNameOwner, resourceKind,
		resourceName) {
	var href = "/manage/" + schemaName + "/" + schemaNameOwner + "/edit/"
			+ resourceKind + "/" + encodeURI(resourceName);
	var items = [];
	items.push('<a href="' + href + '">');
	items.push(resourceName);
	items.push('</a>');
	return items.join("");
};
var searchSchemaIndexTables = function(schemaName, schemaNameOwner,
		resourceData) {
	var urlService = hostBase + apiRefBase + "/table/index/search/"
			+ schemaName + "/" + schemaNameOwner + '/'
			+ encodeURI(resourceData);
	console.log('urlService=[' + urlService + ']');
	$.get(urlService).done(function(res) {
		drawTablesInfoData(res);
	});
};
var searchSchemaIndexViews = function(schemaName, schemaNameOwner, resourceData) {
	var urlService = hostBase + apiRefBase + "/view/index/search/" + schemaName
			+ "/" + schemaNameOwner + '/' + encodeURI(resourceData);
	$.get(urlService).done(function(res) {
		drawViewsInfoData(res);
	});
};
var searchSchemaIndexProcedures = function(schemaName, schemaNameOwner,
		resourceData) {
	var urlService = hostBase + apiRefBase + "/procedure/index/search/"
			+ schemaName + "/" + schemaNameOwner + '/'
			+ encodeURI(resourceData);
	$.get(urlService).done(function(res) {
		drawProceduresInfoData(res);
	});
};
var searchSchemaIndexFunctions = function(schemaName, schemaNameOwner,
		resourceData) {
	var urlService = hostBase + apiRefBase + "/function/index/search/"
			+ schemaName + "/" + schemaNameOwner + '/'
			+ encodeURI(resourceData);
	$.get(urlService).done(function(res) {
		drawFunctionsInfoData(res);
	});
};
var drawTablesInfoData = function(data) {
	var items = [];
	items.push('<div class="table-responsive">');
	items.push('<table class="table table-hover table-striped">');
	items
			.push('<thead><tr><th>Nombre</th><th>Modulo</th><th>Descripción</th></tr></thead>');
	items.push('<tbody>');
	for ( var i in data) {
		items.push('<tr>');
		items.push('<td>');
		items.push(createHREFLink(schemaName, schemaNameOwner, 'table',
				data[i].name));
		items.push('</td>');
		items.push('<td>');
		items.push(data[i].module);
		items.push('</td>');
		items.push('<td>');
		items.push(data[i].description);
		items.push('</td>');
		items.push('</tr>');
	}
	items.push('</tbody>');
	items.push('</table>')
	items.push('</div>');
	$('#' + idTablesContent).empty().append(items.join(''));
};
var drawViewsInfoData = function(data) {
	var items = [];
	items.push('<div class="table-responsive">');
	items.push('<table class="table table-hover table-striped">');
	items
			.push('<thead><tr><th>Nombre</th><th>Modulo</th><th>Descripción</th></tr></thead>');
	items.push('<tbody>');
	for ( var i in data) {
		items.push('<tr>');
		items.push('<td>');
		items.push(createHREFLink(schemaName, schemaNameOwner, 'view',
				data[i].name));
		items.push('</td>');
		items.push('<td>');
		items.push(data[i].module);
		items.push('</td>');
		items.push('<td>');
		items.push(data[i].description);
		items.push('</td>');
		items.push('</tr>');
	}
	items.push('</tbody>');
	items.push('</table>')
	items.push('</div>');
	$('#' + idViewsContent).empty().append(items.join(''));
};
var drawProceduresInfoData = function(data) {
	var items = [];
	items.push('<div class="table-responsive">');
	items.push('<table class="table table-hover table-striped">');
	items
			.push('<thead><tr><th>Nombre</th><th>Modulo</th><th>Descripción</th></tr></thead>');
	items.push('<tbody>');
	for ( var i in data) {
		items.push('<tr>');
		items.push('<td>');
		items.push(createHREFLink(schemaName, schemaNameOwner, 'procedure',
				data[i].name));
		items.push('</td>');
		items.push('<td>');
		items.push(data[i].module);
		items.push('</td>');
		items.push('<td>');
		items.push(data[i].description);
		items.push('</td>');
		items.push('</tr>');
	}
	items.push('</tbody>');
	items.push('</table>')
	items.push('</div>');
	$('#' + idProceduresContent).empty().append(items.join(''));
};
var drawFunctionsInfoData = function(data) {
	var items = [];
	items.push('<div class="table-responsive">');
	items.push('<table class="table table-hover table-striped">');
	items
			.push('<thead><tr><th>Nombre</th><th>Modulo</th><th>Descripción</th></tr></thead>');
	items.push('<tbody>');
	for ( var i in data) {
		items.push('<tr>');
		items.push('<td>');
		items.push(createHREFLink(schemaName, schemaNameOwner, 'function',
				data[i].name));
		items.push('</td>');
		items.push('<td>');
		items.push(data[i].module);
		items.push('</td>');
		items.push('<td>');
		items.push(data[i].description);
		items.push('</td>');
		items.push('</tr>');
	}
	items.push('</tbody>');
	items.push('</table>')
	items.push('</div>');
	$('#' + idFunctionsContent).empty().append(items.join(''));
};
var retrieveSchemaTables = function(schemaName, schemaNameOwner) {
	var urlService = hostBase + apiRefBase + "/table/index/all/" + schemaName
			+ "/" + schemaNameOwner;
	$.get(urlService).done(function(res) {
		drawTablesInfoData(res);
	});
};
var retrieveSchemaViews = function(schemaName, schemaNameOwner) {
	var urlService = hostBase + apiRefBase + "/view/index/all/" + schemaName
			+ "/" + schemaNameOwner;
	$.get(urlService).done(function(res) {
		drawViewsInfoData(res);
	});
};
var retrieveSchemaProcedures = function(schemaName, schemaNameOwner) {
	var urlService = hostBase + apiRefBase + "/procedure/index/all/"
			+ schemaName + "/" + schemaNameOwner;
	$.get(urlService).done(function(res) {
		drawProceduresInfoData(res);
	});
};
var retrieveSchemaFunctions = function(schemaName, schemaNameOwner) {
	var urlService = hostBase + apiRefBase + "/function/index/all/"
			+ schemaName + "/" + schemaNameOwner;
	$.get(urlService).done(function(res) {
		drawFunctionsInfoData(res);
	});
};
var configureTypeAheadForTables = function() {
	var urlService = hostBase + apiRefBase + "/table/index/search/"
			+ schemaName + "/" + schemaNameOwner + "/%QUERYSTRING";
	var dataSource = new Bloodhound({
		datumTokenizer : Bloodhound.tokenizers.whitespace,
		queryTokenizer : Bloodhound.tokenizers.whitespace,
		remote : {
			url : urlService,
			wildcard : '%QUERYSTRING'
		}
	});
	var typeAheadOptions = {
		hint : true,
		highlight : true,
		minLength : 1
	};
	var typeAheadDatasets = {
		display : 'name',
		source : dataSource,
		limit : 5000
	};
	$('#' + idSearchForTables).typeahead(typeAheadOptions, typeAheadDatasets)
			.keyup(onSearchForTablesKeyup);
};
var configureTypeAheadForViews = function() {
	var urlService = hostBase + apiRefBase + "/view/index/search/" + schemaName
			+ "/" + schemaNameOwner + "/%QUERYSTRING";
	var dataSource = new Bloodhound({
		datumTokenizer : Bloodhound.tokenizers.whitespace,
		queryTokenizer : Bloodhound.tokenizers.whitespace,
		remote : {
			url : urlService,
			wildcard : '%QUERYSTRING'
		}
	});
	var typeAheadOptions = {
		hint : true,
		highlight : true,
		minLength : 1
	};
	var typeAheadDatasets = {
		display : 'name',
		source : dataSource,
		limit : 5000
	};
	$('#' + idSearchForViews).typeahead(typeAheadOptions, typeAheadDatasets)
			.keyup(onSearchForViewsKeyup);
};
var configureTypeAheadForProcedures = function() {
	var urlService = hostBase + apiRefBase + "/procedure/index/search/"
			+ schemaName + "/" + schemaNameOwner + "/%QUERYSTRING";
	var dataSource = new Bloodhound({
		datumTokenizer : Bloodhound.tokenizers.whitespace,
		queryTokenizer : Bloodhound.tokenizers.whitespace,
		remote : {
			url : urlService,
			wildcard : '%QUERYSTRING'
		}
	});
	var typeAheadOptions = {
		hint : true,
		highlight : true,
		minLength : 1
	};
	var typeAheadDatasets = {
		display : 'name',
		source : dataSource,
		limit : 5000
	};
	$('#' + idSearchForProcedures).typeahead(typeAheadOptions,
			typeAheadDatasets).keyup(onSearchForProceduresKeyup);
};
var configureTypeAheadForFunctions = function() {
	var urlService = hostBase + apiRefBase + "/function/index/search/"
			+ schemaName + "/" + schemaNameOwner + "/%QUERYSTRING";
	var dataSource = new Bloodhound({
		datumTokenizer : Bloodhound.tokenizers.whitespace,
		queryTokenizer : Bloodhound.tokenizers.whitespace,
		remote : {
			url : urlService,
			wildcard : '%QUERYSTRING'
		}
	});
	var typeAheadOptions = {
		hint : true,
		highlight : true,
		minLength : 1
	};
	var typeAheadDatasets = {
		display : 'name',
		source : dataSource,
		limit : 5000
	};
	$('#' + idSearchForFunctions)
			.typeahead(typeAheadOptions, typeAheadDatasets).keyup(
					onSearchForFunctionsKeyup);
};
var initControls = function() {
	schemaName = $('#' + idSchemaName).val();
	schemaNameOwner = $('#' + idSchemaNameOwner).val();
	configureTypeAheadForTables();
	configureTypeAheadForViews();
	configureTypeAheadForProcedures();
	configureTypeAheadForFunctions();
	retrieveSchemaTables(schemaName, schemaNameOwner);
	retrieveSchemaViews(schemaName, schemaNameOwner);
	retrieveSchemaProcedures(schemaName, schemaNameOwner);
	retrieveSchemaFunctions(schemaName, schemaNameOwner);
	$('#' + idSchemaSynchronize).click(
			function() {
				$.blockUI({ message: 'Procesando...</h1>' }); 
				location.href = '/manage/' + schemaName + '/' + schemaNameOwner
						+ '/synchronize'
			});
};

/* jquery on document ready setup */
$(function() {
	initControls();
});
