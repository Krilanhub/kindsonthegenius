/**
 * 
 */

$('document').ready(function() {
	
	
	$('.editBtn').on('click', function(event) {

		event.preventDefault();

		var href = $(this).attr('href');

		$.get(href, function(student, status) {
			$('#IdEdit').val(student.id);
			$('#nameEdit').val(student.name);
			$('#DepartmentEdit').val(student.Department);
			$('#updatedByEdit').val(student.updatedBy);
			$('#updatedOnEdit').val(student.updatedOn.substr(0, 10));
		});

		$('#editModal').modal();

	});

	$('.deleteButton').on('click', function(e) {
		e.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();
	});
});