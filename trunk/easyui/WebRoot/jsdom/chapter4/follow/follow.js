ADS.addEvent(window,'load',function() {

    // Define an object to move
    var object = document.getElementById('follow');
    
    // Set it to use absolute positioning
    object.style.position = 'absolute';
    
    // Create an event listener for the document's mousemove event
    function eventListener(W3CEvent) {
        var pointer = ADS.getPointerPositionInDocument(W3CEvent);
    
        // Position the object relative to the pointer
        object.style.left = pointer.x + 'px';
        object.style.top = pointer.y + 'px';
    
    }
    // Attach the event listener to the document object's mousemove event
    ADS.addEvent(document,'mousemove',eventListener);

    
});

/*
ADS.addEvent(window, 'load', function(){
	//定义要移动的对象
	var object = document.getElementById('follow');
	
	//为其进行绝对定位
	object.style.position = 'absolute';
	
	//为文档的mouseover事件创建事件侦听器
	function eventListener(W3CEvent) {
		//相对于鼠标指定定位对象
		object.style.left = pointer.x + 'px';
		object.style.top = pointer.y + 'px';
	}
	
	//将事件侦听器指定给文档对象的mouseover事件
	ADS.addEvent(document, 'mouseover', eventListener);
});
*/