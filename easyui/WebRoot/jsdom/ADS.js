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
	
	//函数绑定，修改环境
	function bindFunction(obj, func) {
		return function() {
			func.apply(obj, arguments);
		};
	}
	window['ADS']['bindFunction'] = bindFunction;
	
	//获得浏览器窗口尺寸
	function getBrowserWindowSize() {
		var de = document.documentElement;
		return {
			"width" : (window.innerWidth || (de && de.clientWidth) || document.body.clientWidth),
			"height" : (window.innerHeight || (de && de.clientHeight) || document.body.clientHeight)
			
		};
	};
	window['ADS']['getBrowserWindowSize'] = getBrowserWindowSize;
	
	//下面这个myLogger当作一个构造函数
	function myLogger(id) {
		
		id = id ||'ADSLogWindow';
		//私有属性
		var logWindow = null;
		//私有方法
		var createWindow = function () {
			//取得新窗口在浏览器中居中放置时的左上角位置
			var  browserWindowSize = ADS.getBrowserWindowSize();
			var top = ((browserWindowSize.height - 200)/2) || 0;
			var left = ((browserWindowSize.width - 200)/2) || 0;
			
			//创建作为日志窗口的DOM节点
			//使用受保护的logWindow属性维护引用
			logWindow = document.createElement("UL");
			//指定ID值， 以便必要时在DOM树中能够识别
			logWindow.setAttribute("id",id);
			
			//在屏幕居中定位日志窗口
			logWindow.style.position = 'absolute';
			logWindow.style.top = top + "px";
			logWindow.style.left = left + "px";
			
			//设置固定的大小并允许窗口内容滚动
			logWindow.style.width = "200px";
			logWindow.style.height = "200px";
			logWindow.style.overflow = "scroll";
			
			//添加一些样式以美化外观
			logWindow.style.padding = "0";
			logWindow.style.margin = "0";
			logWindow.style.border = "1px solid black";
			logWindow.style.backgroundColor = "white";
			logWindow.style.listStyle = "none";
			logWindow.style.font = "10px/10px Verdana, Tahoma, Sans";
			
			//将其添加到文档主体中
			document.body.appendChild(logWindow);
			
			
		};
		
		//特权方法，公有方法
		this.writeRaw = function(message) {
			//如果初始窗口不存在，则创建
			if(!logWindow) {
				
				createWindow();
				
			}
			
			//创建列表项并适当地添加样式
			var li = document.createElement("LI");
			li.style.padding = "2px";
			li.style.border = "0";
			li.style.borderBottom = "1px dotted black";
			li.style.margin = "0";
			li.style.color = "#000";
			li.style.font = "9px/9px Verdana, Tahoma, Sans";
			//为日志节点添加 信息
			if(typeof message == "undefined") {
				li.appendChild(document.createTextNode("Message was undefined"));
			} else if (typeof li.innerHTML != undefined) {
				li.innerHTML = message;
			} else {
				li.appendChild(document.createTextNode(message));
			}
			
			//将这个条目添加到日志窗口
			logWindow.appendChild(li);
			
			return true;
		};
		
	}
	
	//公有方法。
	myLogger.prototype = {
			write:function(message){
				//警告message 为空值
				if(typeof message =="string" && message.length == 0 ) {
					return this.writeRaw("ADS.log: null message");
				}
				
				//如果message不是字符串，尝试调用toString（）方法,如果不存在，则记录对象类型
				if(typeof message != "string") {
					if(message.toString) {
						return this.writeRaw(message.toString());
					} else {
						return this.writeRaw(typeof message);
					}
				}
				
				//转换< and >，以便.innerHTML不会将message作为HTML进行解析
				message = message.replace(/</g,"&lt;").replace(/>/g,"&gt;");
				return this.writeRaw(message);
			},
			
			//向日志窗口写入一个标量
			header:function(message) {
				message = '<span style="color:white;background-color:black;font-weigh:bold;padding:0px 5px;">'
					+ message + '</span>';
				return this.writeRaw(message);
			}
	};
	
	if(!window.ADS) {
		window['ADS'] = {};
	}
	
	window['ADS']['log'] = new myLogger();//当作构造函数调用，生成对应实例。
	
	ADS.addEvent(window,'load', function() {
		//创建一个图像元素
		var image = document.createElement('IMG');
		
		//当图像载入后将其添加到文档主体
		ADS.addEvent(image, 'load', function() {
			document.body.appendChild(image);
		});
		
		//如果载入出错则添加错误消息
		ADS.addEvent(image, 'error', function() {
			
			var message = document.createTextNode('The image failed to load');
			
			document.body.appendChild(message);
			
		});
		
		//设置图像的src属性以便浏览器取得图像
		image.setAttribute('src', 'http://advanceddomscripting.com/images/working.jpg');
		
		//除了下面这幅图像不存在而且会发生载入错误外，与外面都相同
		var imageMissing = document.createElement('img');
		ADS.addEvent(imageMissing, 'load', function() {
			document.body.appendChild(imageMissing);
		});
		
		ADS.addEvent(imageMissing, 'error', function() {
			var message = document.createTextNode("imageMissing failed to load");
			document.body.appendChild(message);
		});
		
		//设置图像的src属性以便浏览器取得图像
		imageMissing.setAttribute('src', 'http://advanceddomscripting.com/images/working.jpg');
		
	});
	
	//停止事件冒泡
	function stopPropagation(eventObject) {
		eventObject  = eventObject || getEventObject(eventObject);
		if(eventObject.stopPropagation) {
			eventObject.stopPropagation();
		} else {
			eventObject.cancelBubble = true;
		}
	}
	
	window['ADS']['stopPropagation'] = stopPropagation;
	
	//停止默认事件
	function preventDefault(eventObject) {
		eventObject  = eventObject || getEventObject(eventObject);
		if(eventObject.preventDefault) {
			eventObject.preventDefault();
		} else {
			eventObject.returnValue = false;
		}
	}
	
	window['ADS']['preventDefault'] = preventDefault;
	
	function addLoadEvent(loadEvent, waitForImages) {
		if(!isCompatible()) {
			return false;
		}
		
		//如果等待标记为true，则正常加载
		if(waitForImages) {
			return addEvent(window,'load',loadEvent);
		}
		
		//否则使用一些不同的方式包装addLoadEvent方法
		//以便为this关键字指定正确的内容，同时确保事件不会执行两次
		var init = function() {
			//如果函数调用过了，则返回
			if(arguments.callee.done) {
				return ;
			}
			//标记这个函数，以便检验是否运行过
			arguments.callee.done = true;
			//在document环境中运行载入事件
			loadEvent.apply(document, arguments);
			
		};
		
		//为DOMContentLoaded事件注册侦听器
		/**
		 * 如果浏览器存在addEventlistener（）方法，则全用DOMContentLoaded事件，该事件会在文档标记载入完成时被调用。
		 */
		if(document.addEventListener) {
			document.addEventListener('DOMContentLoaded',init,false);
		}
		
		//对于Safari，使用setInterval
		//document是否载入完成
		/**
		 * 对于Safari，周期性检查document.readyState属性，随时监控文档是否载入完成
		 */
		if(/WebKit/i.test(naviagtor.userAgent)) {
			var _timer = setInterval(function() {
				if(/loaded|complete/.test(document.readyState)) {
					clearInterval(_timer);
					init();
				}
			},10);
		}
		
		//对于IE（使用条件注释）,附加一个在载入过程最后执行的脚本，并检测该脚本是否载入完成
		/**
		 * 对于IE，运用了一点小技巧。即向文档中写入一个新的script标签，但该标签会延迟到文件
		 * 最后才载入.然后，使用script对象的onreadystatechange方法在进行类似的readyState检查后及时调用载入事件。
		 */
		document.write("<script id=__ie_onload defer src=javascript:void(0)><\/script>");
		var script = document.getElementById('__ie_onload');
		script.onreadystatechange = function() {
			if(this.readyState =="complete") {
				init();
			}
		};
		
		/**@end**/
		return true;
	}
	window['ADS']['addLoadEvent'] = addLoadEvent;
	
	//获得事件对象
	function getEventObject(W3CEvent) {
		return W3CEvent || window.event;
	}
	window['ADS']['getEventObject'] = getEventObject;
	
	//获得事件目标对象 
	function getTarget(eventObject) {
		eventObject = eventObject || getEventObject(eventObject);
		//如果是W3C或MSIE的模型
		var target = eventObject.target || eventObject.srcElement;
		
		//如果像Safari中一样是一个文本节点
		//重新将目标对象指定为父元素
		if(target.nodeType == ADS.node.TEXT_NODE) {
			target = node.parentNode;
		}
		return target;
	}
	
	window['ADS']['getTarget'] = getTarget;
	
	//查询是W3C标准还是MSIE，以确定按下的是哪个不同的鼠标键
	//返回对应的包含对应属性的数组
	function getMouseButton(eventObject) {
		eventObject = eventObject || getEventObject(eventObject);
		
		//使用适当的属性初始化一个对象变量
		var buttons = {
				'left' : false,
				'middle' : false,
				'right' : false
		};
		
		//检查eventObject对象的toString()方法的值。W3CDOM对象返回的是MouseEvent，IE返回的是button
		if(eventObject.toString && eventObject.toString().indexOf('MouseEvent') != -1) {
			//W3C方法
			switch(eventObject.button) {
			
			case 0 : buttons.left = true;break;
			
			case 1 : buttons.middle = true;break;
			
			case 2 : buttons.right = true;break;
			
			default : break;
			
			}
		} else if(eventObject.button) {
			//MSIE的方法
			switch(eventObject.button) {
			case 1 : 
				buttons.left = true;
				break;
			case 2 : 
				buttons.right = true;
				break;
			case 3 : 
				buttons.left = true;
				buttons.right = true;
				break;
			case 4 :
				buttons.middle = true;
				break;
			case 5 :
				buttons.left = true;
				buttons.middle = true;
				break;
			case 6 : 
				buttons.middle = true;
				buttons.right = true;
				break;
			case 7 :
				buttons.left = true;
				buttons.middle = true;
				buttons.right = true;
				break;
				default : 
					break;
			}
			
		}else {
			return false;
		}
		return buttons;
	}
	
	window['ADS']['getMouseButton'] = getMouseButton;
	
	//处理鼠标位置，相对于文档的位置
	function getPointerPositionInDocument(eventObject) {
		eventObject = eventObject || getEventObject(eventObject);
		
		var x = eventObject.pageX || (eventObject.clientX + (document.documentElement.scrollLeft || document.body.scrollLeft));
		
		var y = eventObject.pageY || (eventObject.clientY + (document.documentElement.scrollTop || document.body.scrollTOP));
		
		return {'x' : x ,'y' : y};
		
	}
	
	window['ADS']['getPointerPositionInDocument'] = getPointerPositionInDocument;
	
	//获取键盘动作的keyCode值
	function getKeyPressed(eventObject) {
		
		eventObject = eventObject || getEventObject(eventObject);
		
		var code = eventObject.keyCode;
		
		var value = String.fromCharCode(code);
		
		return {'code' : code, 'value' : value};
		
	}
	
	window['ADS']['getKeyPressed'] = getKeyPressed;
	
	//通过ID修改某个元素的样式
	function setStyleById(element, styles) {
		//取得对象的引用
		if(!(element = $(element))) {
			return false;
		}
		//循环遍历styles对象并应用每个属性
		for ( var property in styles) {
			if(!styles.hasOwnProperty(property)) {
				continue;
			}
			
			if(element.style.setProperty) {
				//DOM2样式规范方法
				element.style.setProperty(uncamelize(property,'-'), styles[property], null);
			} else {
				//备用方法
				element.style[camelize(property)] = styles[property];
			}
		}
		return true;
	}
	
	window['ADS']['setStyle'] = setStyleById;
	window['ADS']['setStyleById'] = setStyleById;
	
	//通过类名修改多个元素的样式
	function setStylesByClassName(parent, tag, className, styles) {
		if(!(parent = $(parent))) {
			return false;
		}
		
		var elements = getElementsByClassName(className, tag, parent);
		for ( var e = 0; e < elements.length; e++) {
			setStyleById(elements[e], styles);
		}
		
		return true;
		
	}
	
	window['ADS']['setStylesByClassName'] = setStylesByClassName;
	
	//通过标签名修改多个元素的样式
	function setStylesByTagName(tagname, styles, parent) {
		parent = $(parent) || document;
		var elements = parent.getElementsByTagName(tagname);
		for ( var e = 0; e < elements.length; e++) {
			setStyleById(elements[e], styles);
		}
	}
	
	window['ADS']['setStylesByTagName'] = setStylesByTagName;
	
	//取得包含元素类名的数组
	function getClassNames(element) {
		if(!(element = $(element))) {
			return false;
		}
		//用一个空格替换多个空格，然后用空格分割类名
		return element.className.replace(/\s + /, ' ').split(' ');
	}

	window['ADS']['getClassNames'] = getClassNames;
	
	//检查元素中是否存在某个类
	function hasClassName(element, className) {
		if(!(element = $(element))) {
			return false;
		}
		
		var classes = getClassNames(element);
		
		for ( var i = 0; i < classes.length; i++) {
			//检查className是否匹配，如果是则返回true
			if(classes[i] === className) {
				return true;
			}
		}
		return false;
	}
	window['ADS']['hasClassName'] = hasClassName;
	
	//为元素添加类
	function addClassName(element, className) {
		if(!(element = $(element))) {
			return false;
		}
		//将类名添加到当前className的末尾，如果没有className,则不包含空格
		element.className += (element.className ? ' ':'') + className;
		return true;
	}
	window['ADS']['addClassName'] = addClassName;
	
	//从元素中删除类
	function removeClassName(element, className) {
		if(!(element = $(element))) {
			return false;
		}
		var classes = getClassNames(element);
		var length = classes.length;
		//循环遍历数组删除匹配的项，因为从数组中删除项会使数组变短，所以要反向循环
		for ( var i = length -1; i >= 0 ; i--) {
			if(classes[i] === className) {
				delete(clases[i]);
			}
		}
		element.className = classes.join(' ');
		return (length == classes.length ? false : true);
	}
	window['ADS']['removeClassName'] = removeClassName;
	
	//新增样式表
	function addStyleSheet(url, media) {
		media = media ||'screen';
		var link = document.creatElement('LINK');
		link.setAttribute('rel','stylesheet');
		link.setAttribute('type','text/css');
		link.setAttribute('href',url);
		link.setAttribute('media',media);
		document.getElementsByTagName('head')[0].appendChild(link);
	}
	window['ADS']['addStyleSheet'] = removeClassName;
	
	//移除样式表
	function removeStyleSheet(url, media) {
		var styles = getStyleSheets(url,media);
		for ( var i = 0; i < styles.length; i++) {
			var node = styles[i].ownerNode || styles[i].owningElement;
			//禁用样式表
			styles[i].disabled = true;
			//移除节点
			node.parentNode.removeChild(node);
		}
	}
	window['ADS']['removeStyleSheet'] = removeClassName;
	
	
})();