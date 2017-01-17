//Actions
var ACTION_DEFINE = 1;
var ACTION_COMPOSE = 2;
var ACTION_CONFIGURE = 3;
var ACTION_PREPARE = 4;
var ACTION_EXECUTE = 5;
var ACTION_CONFIGURE_VIEW = 6;

//Action operation
var OPERATION_NEW = 1;
var OPERATION_EDIT = 2;
var OPERATION_VIEW = 3;

//Process status
var STATUS_NOT_RUNNING = "0";
var STATUS_SUSPENDED = "1";
var STATUS_RUNNING = "2";

//Node states
var STATE_DEFAULT = "DEFAULT";
var STATE_SERVICE_NOT_AVAILABLE = "SERVICE_IMPL_NOT_AVAILABLE";
var STATE_SERVICE_NOT_SELECTED = "SERVICE_IMPL_NOT_SELECTED";
var STATE_SERVICE_SELECTED = "SERVICE_IMPL_SELECTED";
var STATE_RUNTIME_CONFIGURED = "RUNTIME_CONFIGURED";
var STATE_NOT_PREPARED = "NOT_PREPARED";
var STATE_PREPARED = "PREPARED";
var STATE_RUNNING = "RUNNING";
var STATE_NOT_RUNNING = "NOT_RUNNING";
var STATE_SUSPENDED = "SUSPENDED";
var STATE_DONE = "DONE";

//Node colors
var COLOR_DEFAULT = "#216477";
var COLOR_SUCCESS = "#3c763d";
var COLOR_WARNING = "#BD6F21";
var COLOR_DANGER = "#a94442";

//Connection colors
var COLOR_CONNECTION_DEFAULT = "#a94442";
var COLOR_CONNECTION_HOVER = "#d9534f";
var COLOR_CONNECTION_PREPARED = "#3c763d";

//Jsplumb stuff
var ANCHOR_DRAG = "Right";
var ANCHOR_DROP = "Left";
var CHART_CONTAINER = "flowchart";
var NODE_CLASS = "window";
var NODE_SELECTOR = "#" + CHART_CONTAINER + " ." + NODE_CLASS;

function getServiceImpl(nodeId) {

    var serviceImpl = "";

    var node = getNode(nodeId);

    if (node.hasOwnProperty("nodeId")) {
        serviceImpl = node.serviceImplId;
    }

    return serviceImpl;
}

function getIsSuspendable(nodeId) {

    var isSuspendable = false;

    var node = getNode(nodeId);

    if (node.hasOwnProperty("suspend")) {
        isSuspendable = node.suspend + "";
    }

    return isSuspendable;
}

function getNode(nodeId) {

    var node = {};

    var nodes = _processGraph.nodeList;

    for (var x in nodes) {
        if (nodes[x].nodeId === parseInt(nodeId)) {
            node = nodes[x];
            break;
        }
    }

    return node;
}

function getIncomingEdge(nodeId) {

    var incomingEdge = {};

    if (nodeId !== "") {
        var incomingEdges = jsPlumb.getConnections({target: nodeId.toString()}); //get current node incoming connection
        if (incomingEdges.length !== 0) { //if incoming connection exists
            incomingEdge = incomingEdges[0];
        }
    }
    return incomingEdge;
}

function getOutgoingEdge(nodeId) {

    var outgoingEdge = {};

    if (nodeId !== "") {
        var outGoingEdges = jsPlumb.getConnections({source: nodeId.toString()}); //get current node outgoing connection
        if (outGoingEdges.length !== 0) { //if outgoing connection exists
            outgoingEdge = outGoingEdges[0];
        }
    }
    return outgoingEdge;
}

//Global dialog utilities
function displayDialog(dialog) {

    cleanupDialog();

    $("#dialog .modal-title").text(dialog.title);

    if (dialog.error) {
        $("#modal-error").append('<i class="fa fa-exclamation-triangle"></i>  ' + dialog.message);
        $("#modal-error").show();
    } else {
        $("#modal-content").text(dialog.message);
        $("#modal-content").show();
    }

    if (typeof dialog.callback !== "undefined") {
        $("#dialogOk").unbind("click");
        $("#dialogOk").bind("click", dialog.callback);
        $("#dialogOk").show();
    }

    $("#dialog").modal("show");
}

function displayConfirmDialog(dialog) {

    $("#dialog .modal-title").text(dialog.title);

    $("#modal-content").text(dialog.message);
    $("#modal-content").show();

    $("#dialogOk").unbind("click");
    $("#dialogOk").bind("click", function(){
        window.location.href = dialog.url;
    });
    
    $("#dialogClose").text("No");
    $("#dialogOk").text("Yes");
    $("#dialogOk").show();
    $("#dialog").modal("show");
}

function cleanupDialog() {
    //cleanup
    $("#modal-content").text("");
    $("#modal-error").text("");
    $("#modal-content").hide();
    $("#modal-error").hide();
    $("#dialogOk").hide();
}

function addFieldError(selector, msg) {

    $(selector).parent().parent().addClass("has-error").addClass("has-feedback");
    if ($(selector).parent().find("span").length === 0) {
        $(selector).parent().append('<span class="glyphicon glyphicon-remove form-control-feedback"></span>');
        $(selector).parent().append('<span class="help-block alert-danger">' + msg + '</span>');
    }
}

//Get ajax service definition detail
function getServiceDefinition(serviceId) {

    if (serviceId > 0) { //if a service definition has been selected
        $.ajax({
            type: "POST",
            url: ctx + "/secure/define/serviceDefinitionDetail.action?decorate=false",
            data: {serviceId: serviceId},
            dataType: "html"
        }).done(function (respdata) { //on success
            $("#ajaxModal").html(respdata);
            $('#ajaxModal').modal();

        }).fail(function (jqXHR, textStatus) { //on error

            displayDialog({
                title: "Service Definition details",
                message: "Server error! Cannot display Service Definition details",
                error: true
            });
        });
    } else {
        displayDialog({
            title: "Service Definition details",
            message: "Please select a \"Service Definition\"",
            error: true
        });
    }
}

//Get ajax service definition detail
function getServiceImplementation(serviceId) {

    if (serviceId > 0) { //if a service definition has been selected
        $.ajax({
            type: "POST",
            url: ctx + "/secure/define/serviceImplementationDetail.action?decorate=false",
            data: {serviceId: serviceId},
            dataType: "html"
        }).done(function (respdata) { //on success
            $("#ajaxModal").html(respdata);
            $('#ajaxModal').modal();

        }).fail(function (jqXHR, textStatus) { //on error

            displayDialog({
                title: "Service Definition details",
                message: "Server error! Cannot display Service Definition details",
                error: true
            });
        });
    } else {
        displayDialog({
            title: "Service Definition details",
            message: "Please select a \"Service Definition\"",
            error: true
        });
    }
}

//Get ajax tool
function getTool(toolId) {

    if (toolId > 0) { //if a tool has been selected
        $.ajax({
            type: "POST",
            url: ctx + "/secure/tool/viewToolDetails.action?decorate=false",
            data: {toolId: $("#toolSelect").val()},
            dataType: "html"
        }).done(function (respdata) { //on success
            $("#ajaxModal").html(respdata);
            $('#ajaxModal').modal("show");

        }).fail(function (jqXHR, textStatus) { //on error

            displayDialog({
                title: "Tool details",
                message: "Server error! Cannot display Tool details",
                error: true
            });
        });
    } else {
        displayDialog({
            title: "Tool details",
            message: "Please select a \"Tool\"",
            error: true
        });
    }
}

//Set menu active
function setMenuActive(id){
    
    //Clean up
    /*$('ul.nav a').each(function(){
        var element = $(this).removeClass('active').parent().parent().removeClass('in').parent();
        if (element.is('li')) {
            element.removeClass('active');
        }
    });*/
    
    $("#" + id).addClass("active");
    $("#" + id + " a").addClass('active').parent().parent().addClass('in').parent();
}
