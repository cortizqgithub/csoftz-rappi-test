/*
Date:     Jan.12/2016
Modified: Feb.01/2016
 */

var idEditTable = "editResource";

// Variable to hold request
var request;

/* Common */
var initControls = function() {
	$('#' + idEditTable).submit(
			function(event) {
				// Abort any pending request
				if (request) {
					request.abort();
				}

				var urlPost = hostBase + apiRefBase + '/resource/' + schemaName
						+ '/' + schemaNameOwner + '/save/' + resourceKind + '/'
						+ resourceName;

				// setup some local variables
				var $form = $(this);

				// Let's select and cache all the fields
				var $inputs = $form.find("input, select, button, textarea");

				// Serialize the data in the form
				var serializedData = $form.serialize();
				
				// Let's disable the inputs for the duration of the Ajax
				// request.
				// Note: we disable elements AFTER the form data has been
				// serialized.
				// Disabled form elements will not be serialized.
				$inputs.prop("disabled", true);

				// Fire off the request to /form.php
				request = $.ajax({
					url : urlPost,
					type : "post",
					data : serializedData
				});

				// Callback handler that will be called on success
				request.done(function(response, textStatus, jqXHR) {
					// Log a message to the console
					if (response.code === 200) {
						toastr.success("Información almacenada con éxito.");
					} else {
						toastr.error("Servidor no responde adecuadamente.");
					}
				});

				// Callback handler that will be called on failure
				request.fail(function(jqXHR, textStatus, errorThrown) {
					// Log the error to the console
					// console.error(
					//		"The following error occurred: " + textStatus,
					//		errorThrown);
					toastr.error("Ha ocurrido un error " + textStatus);
				});

				// Callback handler that will be called regardless
				// if the request failed or succeeded
				request.always(function() {
					// Reenable the inputs
					$inputs.prop("disabled", false);
				});

				// Prevent default posting of form
				event.preventDefault();
			});
};

var initGlobals = function() {
	schemaName = $('#' + idSchemaName).val();
	schemaNameOwner = $('#' + idSchemaNameOwner).val();
	resourceKind = $('#' + idResourceKind).val();
	resourceName = $('#' + idResourceName).val();
};

/* jquery on document ready setup */
$(function() {
	initGlobals();
	initControls();
});