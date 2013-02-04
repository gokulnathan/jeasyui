/*
//add a load event to alter the page
ADS.addEvent(window,'load',function(W3CEvent) {
    
    //locate all the anchor tags with the popup class in the document
    var popups = ADS.getElementsByClassName('popup', 'a');
    for(var i=0 ; i<popups.length ; i++ ) {
        //add a click event listener to each anchor
        ADS.addEvent(popups[i],'click',function(W3CEvent) {
            
            //open the window using the href attribute
            window.open(this.href); 
            
            //cancel the default event
            ADS.eventPreventDefault(W3CEvent);
        });
    }
});*/

//添加载入事件来修改页面
ADS.addEvent(window,'load',function(W3CEvent) {
	//查找文档中带popup类的所有锚标签
	var popups = ADS.getElementsByClassName("popup",'a');
	for ( var int = 0; int < popups.length; int++) {
		//为每个锚添加单击事件侦听器
		ADS.addEvent(popups[i],'click',function(W3CEvent){
			alert("hello");
			//使用href属性打开窗口
			window.open(this.href);
			//取消默认事件
			ADS.eventPreventDefault(W3CEvent);
		});
	}
});









