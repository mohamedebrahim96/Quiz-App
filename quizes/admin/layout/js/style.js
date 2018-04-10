$(function () {

	'use strict';
    
   	
	// Hide Placeholder On Form Focus

	$('[placeholder]').focus(function () {

		$(this).attr('data-text', $(this).attr('placeholder'));

		$(this).attr('placeholder', '');

	}).blur(function () {

		$(this).attr('placeholder', $(this).attr('data-text'));

	});

	
	// Convert Password Field To Text Field On Hover

	var passField = $('.password');

	$('.show-pass').hover(function () {

		passField.attr('type', 'text');

	}, function () {

		passField.attr('type', 'password');

	});

	// Confirmation Message On Button

	$('.confirm').click(function () {

		return confirm('Are You Sure?');

	});

	// Auto Close Alert in 7s
	
	
	setTimeout(function() {
        $(".alert").alert('close');
    }, 7000);
	
	
	$("#datepicker").datepicker({ dateFormat:'yy-mm-dd' });
	
	

});