function showAjaxPopup ()
{
	alert(this);
	id = $('#id');
	if (link) {
		var offset = $(link).offset();
		
		alert(offset.left);
		alert(offset.top);
	}
}

function openPopupWindow (link, element, mode)
{
	if (mode == 'absolute') {
		positionPopupByLink (link, element);
		element.show();
	}
	else if (mode == 'relative') {
		positionRelativePopupByLink (link, element);
		element.show();
	}
	createOverlay ();
}

function closePopupWindow (link)
{
	link.closest('div.ajax-alert-container').hide();
	
	// check if has parent opened
	if (link.parents('div.ajax-alert-container').length < 2) {
		clearOverlay();
	}
}

function positionPopupByEvent (e, element)
{
	// wrap event in jQuery event object
	e = $.event.fix (e);
	element.css('top', '0px');
	element.css('left', '0px');
	element.offset({ top: e.pageY, left: e.pageX });
}

function positionPopupByLink (link, element)
{
	//var position = link.position();
	var position = link.offset();
	var top = position.top;
	var left = position.left;
	
	var windowObject = $(window);
	var border_bottom = windowObject.scrollTop() + windowObject.height();
	var border_right = windowObject.scrollLeft() + windowObject.width();
	
	var left_pos;
	var top_pos;
	var offset = 15;
	var elementWidth = element.width();
	var elementHeight = element.height();
	
	if (link.attr ('positionleft')) {
		left_pos = parseInt (link.attr('positionleft'));
	}
	else if (border_right - (offset *2) >= left + elementWidth) {
		left_pos = left + offset;
	} 
	else {
		left_pos = border_right - offset - elementWidth;
	}
	
	if (border_bottom - (offset *2)>= top + elementHeight) {
		top_pos = top + offset;
	}
	else {
		top_pos = border_bottom - offset - elementHeight;
	}
	
	if (!left_pos) {
		left_pos = '';
	}
	
	if(top_pos < 0) {
		top_pos = 20;
	}
	
	element.css ({left:left_pos, top:top_pos});
}




function openAlertPopup (element)
{
	var windowObject = $(window);
	var window_height = windowObject.height();
	var element_height = element.height();
	
	if( (window_height - element_height) <= 0 ){
		top_pos = $(window).scrollTop()+10;
	}else{
		top_pos = (window_height/2-element_height/2)+$(window).scrollTop();
		if(top_pos <=0){
			top_pos = $(window).scrollTop()+10;
		}
	}
	element.css ({top:top_pos});
	element.show();
}
function closeAlertPopup (element)
{
	element.hide();
	clearOverlay();
}



function positionRelativePopupByLink (link, element)
{
	var relPosition = link.position();
	var relTop = relPosition.top;
	var relLeft = relPosition.left;
	
	var absPosition = link.offset();
	var absTop = absPosition.top;
	var absLeft = absPosition.left;
	
	var windowObject = $(window);
	var border_bottom = windowObject.scrollTop() + windowObject.height();
	var border_right = windowObject.scrollLeft() + windowObject.width();
	
	var left_pos = null;
	var top_pos = null;
	var offset = 15;
	var elementWidth = element.width();
	var elementHeight = element.height();
	
	if (relLeft == absLeft) {
		if (border_right - (offset *2) >= absLeft + elementWidth) {
			left_pos = absLeft + offset;
		} 
		else {
			left_pos = border_right - offset - elementWidth;
		}
	}
	else {
		if (border_right - (offset *2) >= elementWidth + absLeft) {
			left_pos = relLeft+offset;
		} 
		else {
			left_pos = relLeft + border_right - absLeft - elementWidth - offset;
		}
	}
	
	if (relTop == absTop) {
		if (border_bottom - (offset *2)>= absTop + elementHeight) {
			top_pos = absTop + offset;
		}
		else {
			top_pos = border_bottom - offset - elementHeight;
		}
	}
	else {
		if (border_bottom - (offset *2)>= absTop + elementHeight) {
			top_pos = relTop + offset;
		}
		else {
			top_pos = relTop + border_bottom - absTop - elementHeight - offset;
		}
	}
	element.css ({left:left_pos, top:top_pos});
}

function createOverlay ()
{
	var overlay = $('#overlay');
	
	if (!overlay.length) {
		overlay = $('<div id="overlay">&nbsp;</div>');
		$('body').append(overlay);
		
		// set width and height (if scrolls)
		var visibleDocument = $(document);
		var height = visibleDocument.height();
		var width = visibleDocument.width();
		overlay.css ('height', height + 'px');
		overlay.css ('width', width + 'px');
		overlay.click (function() {
			$('div.ajax-alert-container').hide();
			clearOverlay ();
		})
	}
	else {
		overlay.show();
	}
}

function clearOverlay ()
{
	$('#overlay').hide ();
}

