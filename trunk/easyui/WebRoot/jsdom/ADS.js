(function() {
	// ADS命名空间
	if (!window.ADS) {
		window['ADS'] = {};
	}
	// 用来检测当前浏览器是否与整个库兼容
	function isCompatible(other) {
		if (other === false || !Array.prototype.push || !Object.hasOwnProperty
				|| !document.createElement || !document.getElementsByTagName) {
			return false;
		}
		return true;
	}
	;
	window['ADS']['isCompatible'] = isCompatible;

	function $() {
		var elements = new Array;

		// 查找作为参数的所有元素
		for ( var int = 0; int < arguments.length; int++) {

			var element = arguments[i];

			if (typeof element == "string") {

				element = document.getElementById(element);

			}
			// 如果只提供一个参数，则立即返回这个元素
			if (arguments.length == 1) {

				return element;

			}

			// 否则，将它添加到数组中
			elements.push(element);

		}

		return elements;

	}
	window['ADS']['$'] = $;

	function addEvent(node, type, listener) {

		if (!isCompatible()) {
			return false;
		}
		if (!(node = $(node))) {
			return false;
		}
		if (node.addEventListener) {
			// w3c方法
			node.addEventListener(type, listener, false);

			return true;

		} else if (node.attachEvent) {
			// MISE方法
			node['e' + type + listener] = listener;
			note[type + listener] = function() {
				node['e' + type + listener](window.event);
			};
			node.atachEvent('on' + type, node[type + listener]);
			return true;
		}
		// 两种方法都不具备，返回false
		return false;

	}
	;
	window['ADS']['addEvent'] = addEvent;

	// 移除事件
	function removeEvent(node, type, listener) {
		if (!(node = $(node))) {
			return false;
		}
		if (node.removeEventListener) {
			// w3c
			node.removeEventListener(type, listener, false);
			return true;
		} else if (node.detachEvent) {
			// msie
			node.detachEvent("on" + type, node[type + listener]);
			node[type + listener] = null;
			return true;
		}
		return false;

	}
	;
	window['ADS']['removeEvent'] = removeEvent;

	//在某个节点之后插入
	function insertAfter(node, referenceNode) {
		if(!(node = $(node))) {
			return false;
		}
		if(!(referenceNode = $(referenceNode))) {
			return false;
		}
		return referenceNode.parentNode.insertBefore(node,referenceNode.nextSibling);
	}
	window['ADS']['insertAfter'] = insertAfter;

	//移除子节点
	function removeChildren(parent) {
		if(!(parent = $(parent))) {
			return false;
		}
		//当存在该节点时，删除该子节点
		while(parent.firstChild) {
			parent.firstChild.parentNode.removeChild(parent.firstChild);
		}
		//返回父元素，以便实现方法连缀
		return parent;
	}
	;
	window['ADS']['removeChildren'] = removeChildren;

	//添加节点
	function prependChild(parent, newChild) {
		if(!(parent = $(parent))) {
			return false;
		}
		if(!(newChild = $(newChild))) {
			return false;
		}
		
		if(parent.firstChild) {
			//如果存在一个子节点，则在此子节点之前插入
			parent.insertBefore(newChild,parent.firstChild);
		} else {
			//如果没有子节点，直接添加
			parent.appendChild(newChild);
		}
		//再返回父元素，以便实现方法连缀
		return parent;
	};
	
	window['ADS']['prependChild'] = prependChild;

	function exampleLibraryMethod(obj) {
		if (!(obj = $(obj))) {
			return false;
		}
	}

	window['ADS']['exampleLibraryMethod'] = exampleLibraryMethod;

	//根据className获得对应的数组
	function getElementsByClassName(className, tag, parent) {
		parent = parent || document;
		if (!(parent = $(parent))) {
			return false;
		}

		// 查找所有匹配的标签
		var allTags = (tag == "*" && parent.all) ? parent.all : parent
				.getElementsByTagName(tag);
		alert(allTags);
		var matchingElements = new Array;

		// 创建一个正则表达式，来判断className是否正确
		className = className.replace(/\-/g, "\\-");
		var regex = new RegExp("(^|\\s)" + className + "(\\s|$)");
		var element;
		// 检查每一个标签元素，如果符合，放入数组。
		for ( var int = 0; int < allTags.length; int++) {
			element = allTags[i];
			if (regex.test(element.className)) {
				matchingElements.push(element);
			}
		}

		return matchingElements;

	}
	
	window['ADS']['getElementsByClassName'] = getElementsByClassName;
	
	//隐藏或显示效果
	function toggleDisplay(node ,value) {
		if(!(node = $(node))) {
			return false;
		}
		if(node.style.display != "none") {
			node.style.display = "none";
		} else {
			node.style.display = value || "";
		}
		return true;
	}
	window["ADS"]["toggleDisplay"] = toggleDisplay; 
	
	//登记锚点注册器
	function registerListener(anchor, i) {
		ADS.addEvent(anchor, 'click',function(){
			
			alert("my test id is anchor" + i);
		});
	}
	
	function initAnchors(W3CEvent) {
		for ( var int = 0; int < 3; int++) {
			var anchor = document.getElementById("anchor" + i);
			registerListener(anchor, i);
		}
	}
	
	ADS.addEvent(window, 'load',initAnchors);
	
	function registerMultiStateAnchorListeners(anchor, anchorImage, path, extension){
		//载入鼠标悬停状态的图像
		//载入过程与其余的脚本
		//异步进行
		var imageMouseOver = new Image();
		imageMouseOver.src = path + '-over' + extension;
		
		//当鼠标悬停时变换图像的源文件
		ADS.addEvent(anchor, 'mouseover', function(W3CEvent){
			anchorImage.src = imageMouseOver.src;
		});
		
		//当鼠标移出时将图像变换为原始文件
		ADS.addEvent(anchor, 'mouseout', function(W3CEvent) {
			anchorImage.src = path + extension;
		});
		
		//载入鼠标按下时的图像
		var imageMouseDown = new Image();
		imageMouseDown.src = path + '-down' + extension;
		
		//鼠标按下时将图像变换为按下状态的源文件
		ADS.addEvent(anchor, 'mousedown', function(W3CEvent) {
			anchorImage.src = imageMouseDown.src;
		});
		
		//当鼠标放开时图像变换为原始文件
		ADS.addEvent(anchor, 'mouseup', function(W3CEvent) {
			anchorImage.src = path + extension;
		});
	};
	
	function initMultiStateAnchors(W3CEvent) {
		//查找页面中所有的锚
		var anchors = ADS.getElementsByClassName('multiStateAnchor', 'a', document);
		//遍历所有的锚元素
		for ( var int = 0; int < anchors.length; int++) {
			//找到锚中的第一个子图像元素
			var anchorImage = anchors[i].getElementsByTagName('img')[0];
			
			if(anchorImage) {
				//如果存在图像元素，解析其源路径
				var extensionIndex = anchorImage.src.lastIndexOf(".");//扩展名前面的.所在的位置
				var path = anchorImage.src.substr(0, extensionIndex);//路径
				var extension = anchorImage.src.substring(extensionIndex, anchorImage.src.length);//扩展名
				//添加各种鼠标处理程序，同时预先加载图像
				registerMultiStateAnchorListeners(anchor[i], anchorImage, path, extension);
				
			}
		}
	}
	
	//当文档载入完成时修改具有特定标记的锚
	ADS.addEvent(window, 'load', initMultiStateAnchors);
	
})();