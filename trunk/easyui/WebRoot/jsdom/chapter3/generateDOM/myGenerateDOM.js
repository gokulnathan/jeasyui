/*
 * myGenerateDOM对象的新命名空间
 */
(function(){
	
	//只转义反斜杠，单引号，或者换行符
	function encode(str){
		if(!str) {
			return null;
		}
		str = str.replace(/\\/g, '\\\\');
		str = str.replace(/';/g, "\\'");
		str = str.replace(/\s + ^/mg, "\\n");
		return str;
	}
	//检查是否存在$变量
	function checkForVariable(v) {
		//如果没有$符号
		if(v.indexOf('$') == -1) {
			v = '\'' + v +'\'';//改成'v'
		} else {
			//因MSIE会添加锚的完整路径，帮需要取得该字符串从$到结尾处的子字符串
			v = v.substring(v.indexOf('$') + 1);
			requiredVariables += 'var ' + v + ';\n';
		}
		return v;
	}
	
	
	var domCode = '';
	
	var nodeNameCounters = [];
	
	var requiredVariables = '';
	
	var newVariables = '';
	
	function generate(strHTML, strRoot) {
		//将HTML代码添加到页面主体中，以便能够遍历相应的DOM树
		var domRoot = document.getElementById("DIV");
		domRoot.innerHTML = strHTML;
		//重置变量
		domCode = '';
		nodeNameCounter = [];
		requiredVariables = '';
		newVariables = '';
		//使用processNode()代理domRoot中的所有子节点
		var node = domRoot.firstChild;
		while(node) {
			ADS.walkTheDOMRecursive(processNode, node, 0, strRoot);
			node = node.nextSibling;
		}
		
		//输出生成的代码
		domCode = '/* requiredVariables in this code \n' + requiredVariables
				+ '*/\n\n' + domCode + '\n\n'
				+ '/* new objects in this code\n ' + newVariables + '*/\n\n';
		
		return domCode;
	}
	
	function processAttribute(tabCount, refParent) {
		
	}
	
	//遍历子节点
	function processNode(tabCount, refParent) {
		//根据树的深度级别重复制表符，以便对每一行进行适当的缩进
		var tabs = (tabCount ? '\t'.repeat(parseInt(tabCount)):'');
		
		//确定节点类型并处理元素和文本节点
		switch(this.nodeType) {
		case ADS.node.ELEMENT_NODE:
			//计数器加1并创建一个使用标签和计数器的值
			//表示的新变量，例如a1,a2,a3
			if(nodeNameCounters[this.nodeName]) {
				++nodeNameCounters[this.nodeName];
			} else {
				nodeNameCounters[this.nodeName] = 1;
			}
			
			var ref = this.nodeName.toLowerCase() + nodeNameCounters[this.nodeName];
			
			//添加创建这个元素的DOM代码行
			domCode += tabs + 'var ' + ref + ' = document.createElement(\'' + this.nodeName + '\');\n';
			
			//将新变量添加到列表中，以便在结果中报告它们
			newVariables += '' + ref + ';\n';
			
			//检测是否存在属性，如果是，则循环遍历这些属性，并使用processAttribute() 方法遍历它们的DOM树
			if(this.attributes) {
				for ( var int = 0; int < this.attributes.length; int++) {
					ADS.walkTheDOMRecursive(processAttribute, this.attributes[i], tabCount, ref));
				}
			}
			
			break;
			
		case ADS.node.TEXT_NODE:
			//检测文本节点除了空白符之外的值 
			var value = (this.nodeValue ? encode(this.nodeValue.trim()) : '');
			if(value) {
				//计数器加1并创建一个使用txt和计数器的值，表示的新变量，例如txt1,txt2
				if(nodeNameCunters['txt']) {
					++nodeNameCunters['txt'];
				} else {
					nodeNameCunters['txt'] = 1;
				}
				var ref = 'txt' + nodeNameCounters['txt'];
				//检查是不是$var格式的值
				value = checkForVariable(value);
				
				//添加创建这个元素的DOM代码
				domCode += tabs + 'var ' + ref + ' = document.createTextNode(' + value + ');\n';
				
				//将新变量添加到列表中，以便在结果中报告它们
				newVariables += '' + ref +  ';\n';
			} else {
				//如果这个值不存在（或者只有空白符），则返回。即这个节点将不会被添加到父节点中
				return;
			}
			
			break;
			
		default : break;
		
		}
		
		//添加将这个节点添加到其父节点的代码
		if(refParent) {
			domCode += tabs + refParent + '.appendChild(' + ref + ');\n';
		}
		
		return ref;
	}
	
	window['myGenerateDOM'] = generate;
	
})();