var smallWindow = 560;

$(function () {
    //Start metis menu 
    $('#side-menu').metisMenu({
        toggle: false
    });

    toggleMenu();

});

//Set menu active
function setMenuActive(id) {

    //Clean up
    $('ul.nav a').each(function () {
        var element = $(this).removeClass('active').parent().parent().removeClass('in').parent();
        if (element.is('li')) {
            element.removeClass('active');
        }
    });

    $("#" + id).addClass("active");
    $("#" + id + " a").addClass('active').parent().parent().addClass('in').parent();
}

var load = true;
function toggleMenu() {
    var w = 0;
    if (load)
        w = $(window).width();
    else if ($("aside").hasClass("toggle-off"))
        w = smallWindow + 1;
    if (w <= smallWindow) {
        $("aside").addClass("toggle-off");
        $("section").addClass("toggle-off");
        $("footer").addClass("toggle-off");
        $("#toggle-menu").removeClass("fa-chevron-left");
        $("#toggle-menu").addClass("fa-chevron-right");
    } else {
        $("aside").removeClass("toggle-off");
        $("section").removeClass("toggle-off");
        $("footer").removeClass("toggle-off");
        $("#toggle-menu").removeClass("fa-chevron-right");
        $("#toggle-menu").addClass("fa-chevron-left");
    }
    load = false;
}

function format(n) {
    return ("" + n).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function formatPercentage(a, b) {
    return Math.round(1000. * a / b) / 10 + "%";
}

//write REST response user
function writeMsgs(data, iddiv_msgs) {

	$.each(data, function(index, msg) {
		var classs = 'alert alert-info';
		if (msg.type == 'INFO')
			classs = 'alert alert-success';
		else if (msg.type == 'ERROR')
			classs = 'alert alert-danger';
		var div = $('<div class="' + classs + '"><strong>' + msg.type
				+ '</strong>: ' + msg.text + ' </div>"');
		$("#" + iddiv_msgs).append(div);

	});
}
//write REST response user
function writeMsgsError(msg, iddiv_msgs) {

	var classs = 'alert alert-danger';
	var div = $('<div class="' + classs + '">' + msg + ' </div>"');
	$("#" + iddiv_msgs).append(div);

}
