$(document).ready(function() {
	
	$('.table .oBtn').on('click', function(event){	
		event.preventDefault();
		
		var row = $(this).closest("tr");
		var position = row.find(".position").text()
		var vacancyId = row.find(".vacancyId").text();
		
		$('.replyForm #modelLabel').text("Жұмыс орны: \"" + position + "\"");
		$('.replyForm #vacancyId').val(vacancyId);
		$('.replyForm #exampleModal').modal();
		
	});
});