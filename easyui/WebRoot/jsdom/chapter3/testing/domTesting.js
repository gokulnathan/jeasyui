/*
ADS.addEvent(window, 'load', function() {
    ADS.log.header('testNodeName');
    ADS.log.write('nodeName is: ' + document.getElementById('firefox').nodeName);
});


ADS.addEvent(window,'load',function () {
    ADS.log.header('The node value of the anchor');
    ADS.log.write('nodeValue is: ' + document.getElementById('firefox').nodeValue);
});

ADS.addEvent(window,'load', function  () {
    ADS.log.header('Testing nodeType');
    ADS.log.write('nodeType is: ' + document.getElementById('firefox').nodeType);
});

ADS.addEvent(window, 'load', function() {
    ADS.log.header('List child nodes of the document body');
    for( var i = 0 ; i < document.body.childNodes.length ; i++ ) {
        ADS.log.write(document.body.childNodes.item(i).nodeName);
    }
});

ADS.addEvent(window, 'load', function() {
    ADS.log.header('Testing Attributes');
    var firefoxAnchor = document.getElementById('firefox');
    for(var i=0 ; i < firefoxAnchor.attributes.length ; i++) {
        ADS.log.write(
            firefoxAnchor.attributes.item(i).nodeName
                + ' = '
                + firefoxAnchor.attributes.item(i).nodeValue
        );
    }
});
*/
ADS.addEvent(window, 'load', function() {
    ADS.log.header('Attributes And ChildNodes');

    var h2 = document.getElementsByTagName('H2')[0];

    ADS.log.write(h2.nodeName);
    ADS.log.write(h2.nodeName + ' hasChildNodes: ' + h2.hasChildNodes());
    ADS.log.write(h2.nodeName + ' childNodes: ' + h2.childNodes);
    ADS.log.write(h2.nodeName + ' number of childNodes: ' + h2.childNodes.length);
    
    ADS.log.write(h2.nodeName + ' attributes: ' + h2.attributes);
    ADS.log.write(h2.nodeName + ' number of attributes: ' + h2.attributes.length);
    
    // This line will error in MSIE
    ADS.log.write(h2.nodeName + ' hasAttributes: ' + h2.hasAttributes());
});
/*
ADS.addEvent(window, 'load', function() {
    ADS.log.header('Append Child');
    var newChild = document.createElement('LI')
    newChild.appendChild(document.createTextNode('A new list item!'));	
    var list = document.getElementById('browserList');
    list.appendChild(newChild);
});


ADS.addEvent(window, 'load', function() {
    ADS.log.header('Insert Before');
    var newChild = document.createElement('LI')
    newChild.appendChild(document.createTextNode('A new list item!'));
    var list = document.getElementById('browserList');
    list.insertBefore(newChild,list.lastChild);
});



ADS.addEvent(window, 'load', function() {
    ADS.log.header('Replace a node');
    var newChild = document.createElement('LI')
    newChild.appendChild(document.createTextNode('A new list item!'));
    var firefoxLi = document.getElementById('opera');
    firefoxLi.parentNode.replaceChild(newChild,firefoxLi);
});

ADS.addEvent(window, 'load', function() {
    ADS.log.header('Remove a node');
    var firefoxLi = document.getElementById('msie');
    firefoxLi.parentNode.removeChild(firefoxLi);
});

ADS.addEvent(window, 'load', function() {
    //ADS.log.header('Clone and Move a Node');
    var firefoxLi = document.getElementById('firefoxListItem');
    var firefoxLiClone = firefoxLi.cloneNode(true);
    var unorderedList = firefoxLi.parentNode;

    // Apped to the list
    unorderedList.appendChild(firefoxLi);
    // Append to the list
    unorderedList.appendChild(firefoxLiClone);
});

ADS.addEvent(window,'load',function() {
    ADS.log.header('Get Safari href attribute');
    var safariAnchor = document.getElementById('safari');
    var href = safariAnchor.getAttribute('href');
    ADS.log.write(href);
});

ADS.addEvent(window,'load',function() {
    ADS.log.header('Set Safari title attribute');
    var safariAnchor = document.getElementById('safari');
    safariAnchor.setAttribute('title','Safari is for Mac OS X');
});

ADS.addEvent(window,'load',function() {
    ADS.log.header('Remove Firefox title attribute');
    var firefox = document.getElementById('firefoxListItem');
    firefox.removeAttribute('title');
});

ADS.addEvent(window,'load',function() {
    ADS.log.header('Get all browserList elements by tag name');
    var list = document.getElementById('browserList');
    var ancestors = list.getElementsByTagName('*');
    for(i = 0 ; i < ancestors.length ; i++ ) {
        ADS.log.write(ancestors.item(i).nodeName);
    }
});

*/

//获得浏览器内容的所有标签节点
ADS.addEvent(window, 'load', function() {
	ADS.log.header("List childs of document body!");
	for ( var int = 0; int < document.body.childNodes.length; int++) {
		ADS.log.write(document.body.childNodes.item(i).nodeName);
	}
});

//获得某个节点的所有属性名称和内容
ADS.addEvent(window,'load', function() {
	ADS.log.header("Attributes");
	var firefoxAnchor = document.getElementById("firefox");//获得某个节点
	//循环某个节点的所有属性
	for ( var int = 0; int < firefoxAnchor.attributes.length; int++) {
		//firefoxAnchor.attributes[i].nodeName
		//firefoxAnchor.attributes.getNamedItem("href").nodeValue 取得其中的一个具体属性内容
		ADS.log.write(firefoxAnchor.attributes.item(i).nodeName + "=" + firefoxAnchor.attributes.item(i).nodeValue);
	}
});

ADS.addEvent(window, 'load', function() {
	ADS.log.header("Attributes And ChildNodes");
	var h2 = document.getElementsByTagName("H2")[0];
	ADS.log.write(h2.nodeName);
	ADS.log.write(h2.nodeName + " hasChildNodes:" + h2.hasChildNodes());
	ADS.log.write(h2.nodeName + " childNodes:" + h2.childNodes);
	ADS.log.write(h2.nodeName + " number of childNodes:" + h2.childNodes.length);
	ADS.log.write(h2.nodeName + " attributes:" + h2.attributes);
	ADS.log.write(h2.nodeName + " number of attributes:" + h2.attributes.length);
	//下面这行在MSIE中会报错,在firefox,opera, safari中，即使没有节点定义的属性，其attributes属性仍有效而且长度为0.
	ADS.log.write(h2.nodeName + " hasAttributes:" + h2.hasAttributes());
	
});

ADS.addEvent(window, 'load', function() {
	ADS.log.header("Append Child");
	var newChild = document.createElement("LI");
	newChild.appendChild(document.createTextNode("A new list item!"));
	var list = document.getElementById("browserList");
	//添加到最后面
	list.appendChild(newChild);
	//在倒数第二行插入,此时要注意FireFox,Opera,Safari浏览器最后由空白字符组成Text节点，不会忽略。而IE则会忽略，结果看上去就正确。
	//list.insertBefore(newChild, list.lastChild);
	
});

//替换节点
ADS.addEvent(window, 'load', function(){
	ADS.log.header("replace a node");
	var newChild = document.createElement("LI");
	newChild.appendChild(document.createTextNode("A new list item"));
	var firefoxLi = document.getElementById("firefoxListItem");
	firefoxLi.parentNode.replaceChild(newChild, firefoxLi);//由父节点控制替换
});

//删除节点
ADS.addEvent(window, 'load', function(){
	ADS.log.header("Remove a node");
	var firefoxLi = document.getElementById("firefoxListItem");
	firefoxLi.parentNode.removeChild(firefoxLi);//由父节点删除
});



