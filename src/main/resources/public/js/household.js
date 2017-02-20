var _ctx = $("meta[name='ctx']").attr("content");
$(document).ready(function () {
    setMenuActive("household-list");
    var table = $("#householdlist").DataTable({
        responsive: true,
        lengthChange: false,
        pageLength: 10,
        buttons: ['csv', 'excel', 'pdf'],
        columnDefs: [
            {targets: [1, 2, 3, 4, 5, 6, 7, 8, 9], render: $.fn.dataTable.render.number(',', '.', 0), 'className': 'numeric'}
        ]
    });

    table.buttons().container().appendTo('#householdlist_wrapper .col-sm-6:eq(0)');
    $('option[value=afar]').attr('selected', 'selected');
});