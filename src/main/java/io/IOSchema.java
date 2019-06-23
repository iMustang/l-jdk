package io;

/**
 * @Title: IOSchema
 * Java IO的大纲
 */
public class IOSchema {
	/**
	 * "流"代表了任何有能力产生数据的数据源对象，接收数据的接收端对象。
	 * "流"屏蔽了实际的I/O设备中处理数据的细节。
	 *
	 *
	 * 输入流（高层抽象类）：InputStream、Reader
	 * 		都含有read()，用于读取单个字节、字节数组（byte[]），或是单个字符、字符数组（char[]）
	 * 输出流（高层抽象类）：OutputSteam、Writer
	 * 		都含有write()，用于写入单个字节、字节数组，或是单个字符、字符数组
	 *
	 * 字节流：InputStream、OutputStream
	 * 字符流：Reader、Writer
	 *
	 * Reader、Writer提供了兼容Unicode、面向字符的I/O功能
	 * 设计Reader、Writer继承层次结构主要是为了国际化。InputStream、OutputStream继承层次结构仅支持8位字节流，不能很好地处理16位的Unicode字符
	 *
	 * 使用I/O时，尽量使用Reader、Writer，当无法满足需要时，使用面向字节的类。
	 *
	 * InputStream
	 *	  表示从不同数据源产生输入的类，数据源包括：
	 *	  	ByteArrayInputStream：字节数组
	 *	    StringBufferInputStream（已弃用）：String对象
	 *	    FileInputStream：文件
	 *	    PipedInputStream：管道
	 *	    SequenceInputStream：一个由其他种类的流组成的序列，以便将它们收集合并到一个流内
	 *
	 *	    FilterInputStream：为装饰器类提供基类，装饰器类可以把属性、有用的接口与输入流连接在一起
	 *
	 *	OutputStream
	 *	  表示输出去往的目标，包括：
	 *	  	ByteArrayOutputStream：字节数组
	 *	    FileOutputStream：文件
	 *	    PipedOutputStream：管道
	 *
	 *	    FilterOutputStream：为装饰器类提供基类
	 *
	 *	字节流装饰器类：
	 *	  FilterInputStream：从InputStream读取数据，完成两件事情：
	 *	  	第1件事情：
	 *	  		DataInputStream：读取基本类型的数据、String对象（readByte()、readFloat()等）。搭配相应的DataOutputStream，可以通过数据流将基本类型的数据从一个地方迁移到另一个地方。
	 *	    第2件事情：
	 *	    	在内部修改InputStream的行为方式：是否缓冲、是否保留它度过的行（允许查询行数、设置行数）、是否把单一字符推回输入流等等。
	 *
	 *	    	BufferedInputStream：使用缓冲区，使用它可以防止每次读取时都得进行实际写操作。
	 *	    	LineNumberInputStream（已弃用）：跟踪输入流中的行号
	 *	    	PushbackInputStream：具有能弹出一个字节的缓冲区，将读到的最后一个字符回退。为Java构建编译器做实验。
	 *
	 *	  FiterOutputStream：向OutputStream写入
	 *	  	DataOutputStream：对应DataInputStream，将基本类型数据、String对象输出到流中，writeByte()、writeFloat()等。
	 *	    PrintStream：以可视化格式打印所有的基本类型数据、String对象。DataOutStream的目的是将数据元素置入流中，使DataOutputStream能够可移植重构它们。
	 *	    	PrintStream捕捉了所有的IOException，使用时需要使用checkError()自行检查是否出错
	 *	    	PrintStream未完全国际化，不能以平台无关的方式处理换行。
	 *	    BufferedOutputStream：使用缓冲区，使用它避免每次发送数据时都要进行实际的写操作。
	 *
	 *	Reader（Java1.1中的类）			对应的Java1.0中的字节流类
	 *	  FileReader					FileInputStream
	 *	  StringReader					StringBufferInputStream
	 *	  CharArrayReader				ByteArrayInputStream
	 *	  PipedReader					PipedInputStream
	 *
	 *  Writer（Java1.1中的类）			对应的Java1.0中的字节流类
	 *    FileWriter					FileOutputStream
	 *    StringWriter
	 *    CharArrayWriter				ByteArrayOutputStream
	 *    PipedWriter					PipedOutputStream
	 *
	 * 	字符流装饰器类：					相应的Java1.0中的字节流装饰器类
	 * 	  BufferedReader				BufferedInputStream
	 * 	  	  LineNumberReader			LineNumberInputStream
	 * 	  FilterReader					FilterInputStream
	 * 	  	  PushbackReader			PushbackInputStream
	 *
	 * 	  BufferedWriter				BufferedInputStream
	 * 	  PrintWriter					PrintStream
	 *    FilterWriter(抽象类，无子类）	FilterInputStream
	 *
	 * 	  PrintWriter与PrintStream目的相同，都是为了可视化打印
	 *	  为了更容易过渡到使用PrintWriter，PrintWriter提供既能接受Writer、又能接受OutputStream的构造器。
	 *	  为了更容易输出到文件，Java5中给PrintWriter添加了File的构造参数
	 *
	 *
	 *  适配器类：
	 *    InputStreamReader：将InputStream转换为Reader
	 *    OutputStreamReader：将OutStream转换为Writer
	 *
	 */

	/**
	 *	自我独立的类：RandomAccessFile
	 *
	 * 	RandomAccessFile可以在一个文件内向前、向后移动。
	 * 	RandomAccessFile只用于文件操作。
	 *
	 * 	RandomAccessFile不是InputStream、OutputStream类继承体系结构中的一部分。
	 * 	RandomAccessFile实现了DataInput、DataOutput接口（DataInputStream、DataOutStream也实现了这两个接口）。
	 *
	 *	RandomAccessFile的大多数功能被nio存储映射文件取代。
	 *
	 */
}
