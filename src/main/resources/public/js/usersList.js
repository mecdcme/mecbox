var _ctx = $("meta[name='ctx']").attr("content");
	var table;
	$(document)
			.ready(
					function() {
						setMenuActive("users-list");

						  table = $('#userslist')
								.DataTable(
										{
											dom : 'Bfrtip',
											responsive : true,
											buttons : [ {
												extend : 'csvHtml5',
												 filename: 'usersList',
												 title: 'usersList',
												exportOptions : {
													columns : [ 0, 1, 2, 3, 4 ]
												}
											}, {
												extend : 'excelHtml5',
												 filename: 'usersList',
												 title: 'usersList',
												exportOptions : {
													columns : [ 0, 1, 2, 3, 4 ]
												}
											}, {
												extend : 'pdfHtml5',
												 filename: 'usersList',
												 title: 'usersList',
												exportOptions : {
													columns : [ 0, 1, 2, 3, 4 ]
												}
											} ],
											"ajax" : {
												"dataType" : 'json',
												"contentType" : "application/json; charset=utf-8",
												"type" : "POST",
												"url" : _ctx
														+ "/users/restlist",
												"dataSrc" : function(json) {

													return json;
												}
											},
											"columns" : [
													{
														'data' : 'userid'
													},
													{
														'data' : 'nome'
													},
													{
														'data' : 'cognome'
													},
													{
														'data' : 'email'
													},
													{
														'data' : 'role.role'
													},
													{
														"render" : function(
																data, type, row) {
															return '<a class="btn btn-sm btn-primary" href="javascript:void(0)" title="Edit" onclick="javascript:edit_user('
																	+ row.userid
																	+ ');"><i class="glyphicon glyphicon-pencil"></i> Edit</a>';
														},
														"orderable": false
													},
													{
														"render" : function(
																data, type, row) {
															return '<a class="btn btn-sm btn-danger" href="javascript:void(0)" title="Delete" onclick="javascript:open_delete('
																	+ row.userid+ ',\''+ row.email+'\');"><i class="glyphicon glyphicon-trash"></i> Delete</a>';

														},
														"orderable": false
													}

											]
										});

						table.buttons().container().appendTo('#userslist_wrapper .col-sm-6:eq(0)');

						 

						$('#modal_form').on('hide.bs.modal', function() {
							close();
						})
						$('#modalDelete_form').on('hide.bs.modal', function() {
							$('#delEmail').empty();  
							$('#delId').empty();  
							$('#msgsDel').empty();  
							
						})
						
					});

	function add_user() {
		save_method = 'add';
		$('#form')[0].reset(); // reset form on modals
		$('[name="email"]').prop("readonly", false);

		$('.form-group').removeClass('has-error'); // clear error class
		$('.help-block').empty(); // clear error string
		$('#modal_form').modal('show'); // show bootstrap modal
		$('.modal-title').text('Add User'); // Set Title to Bootstrap modal title
		$('#msgs').empty();
	}

	function edit_user(id) {
		save_method = 'update';
		$('#form')[0].reset(); // reset form on modals
		$('.form-group').removeClass('has-error'); // clear error class
		$('.help-block').empty(); // clear error string
		$('#msgs').empty();
		//Ajax Load data from ajax
		$.ajax({
			url : _ctx + "/users/restgetUser?id=" + id,
			type : "GET",
			dataType : "JSON",
			success : function(data) {

				$('[name="userid"]').val(data.userid);
				$('[name="nome"]').val(data.nome);
				$('[name="cognome"]').val(data.cognome);
				$('[name="email"]').val(data.email);
				$('[name="email"]').prop("readonly", true);
				$('[name="role"] option[value=' + data.role.role + ']').prop(
						'selected', true);
				//      $('[name="gender"]').val(data.gender);
				//     $('[name="address"]').val(data.address);
				//    $('[name="dob"]').datepicker('update',data.dob);
				$('#modal_form').modal('show'); // show bootstrap modal when complete loaded
				$('.modal-title').text('Edit User'); // Set title to Bootstrap modal title

			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('Error get data from ajax');
			}
		});
	}

	function reload_table() {
		// /users/restlist
		table.ajax.reload(null, false); //reload datatable ajax

		//ricarica_pagina();
	}

	function ricarica_pagina() {
		// /users/restlist
		location.reload();
	}

	function close() {
		// /users/restlist

		ricarica_pagina();
	}

	function save() {
		$('#btnSave').text('saving...'); //change button text
		$('#btnSave').attr('disabled', true); //set button disable 
		var url;

		if (save_method == 'add') {
			url = _ctx + "/users/restNewUser";
		} else {
			url = _ctx + "/users/restUpdateUser";
		}

		// ajax adding data to database
		$.ajax({
			url : url,
			type : "POST",
			data : $('#form').serialize(),
			dataType : "JSON",
			success : function(data) {
				$("#msgs").empty();
				//  if(data>0) //if success close modal and reload ajax table
				// {
				//     $('#modal_form').modal('hide');
				//    reload_table();
				// }

				if (data) {
					$.each(data, function(index, msg) {
						var classs = 'alert alert-info';
						if (msg.type == 'INFO')
							classs = 'alert alert-success';
						else if (msg.type == 'ERROR')
							classs = 'alert alert-danger';
						var div = $('<div class="'+classs+'"><strong>'
								+ msg.type + '</strong>: ' + msg.text
								+ ' </div>"');
						$("#msgs").append(div);

					});
				}
				$('#btnSave').text('Salva'); //change button text
				$('#btnSave').attr('disabled', false); //set button enable 

			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('Error adding / update data');
				$('#btnSave').text('Salva'); //change button text
				$('#btnSave').attr('disabled', false); //set button enable 

			}
		});
	}

	function open_delete(id,email) {
		$('#btnDelete').show(); //set button enable 
		$('#delEmail').text(email); //change button text
		$('#delId').val(id);  
		$('#modalDelete_form').modal('show'); // show bootstrap modal
		$('#msgsDel').empty();
		 
	}
	function delete_user() {
		 var id=$('#delId').val();  
			$.ajax({
				url : _ctx + "/users/restDeleteUser?id=" + id,
				type : "POST",
				dataType : "JSON",
				success : function(data) {
					 
					$("#msgsDel").empty();
		 
				if (data) {
					$.each(data, function(index, msg) {
						var classs = 'alert alert-info';
						if (msg.type == 'INFO')
							classs = 'alert alert-success';
						else if (msg.type == 'ERROR')
							classs = 'alert alert-danger';
						var div = $('<div class="'+classs+'"><strong>'
								+ msg.type + '</strong>: ' + msg.text
								+ ' </div>"');
						$("#msgsDel").append(div);

					});
				}
			 
				$('#btnDelete').hide(); //set button enable 
					reload_table();

				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert('Error deleting data');
				}
			});

		 
	}