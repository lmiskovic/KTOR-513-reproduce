# KTOR-513-reproduce
Minimal ktor project used to reproduce issue "java.lang.NullPointerException: Current thread is not associated with any request and is not a background thread" described in https://youtrack.jetbrains.com/issue/KTOR-513

Here is the stacktrace of the issue:

java.lang.NullPointerException: Current thread is not associated with any request and is not a background thread
	at com.google.appengine.api.ThreadManager.getCurrentEnvironmentOrThrow(ThreadManager.java:149)
	at com.google.appengine.api.ThreadManager.backgroundThreadFactory(ThreadManager.java:120)
	at com.google.appengine.api.ThreadManager.createBackgroundThread(ThreadManager.java:140)
	at com.example.ApplicationKt$module$1$1.invokeSuspend(Application.kt:29)
	at com.example.ApplicationKt$module$1$1.invoke(Application.kt)
	at com.example.ApplicationKt$module$1$1.invoke(Application.kt)
	at io.ktor.server.routing.Route$buildPipeline$1$1.invokeSuspend(Route.kt:116)
	at io.ktor.server.routing.Route$buildPipeline$1$1.invoke(Route.kt)
	at io.ktor.server.routing.Route$buildPipeline$1$1.invoke(Route.kt)
	at io.ktor.util.pipeline.SuspendFunctionGun.loop(SuspendFunctionGun.kt:120)
	at io.ktor.util.pipeline.SuspendFunctionGun.proceed(SuspendFunctionGun.kt:78)
	at io.ktor.util.pipeline.SuspendFunctionGun.execute$ktor_utils(SuspendFunctionGun.kt:98)
	at io.ktor.util.pipeline.Pipeline.execute(Pipeline.kt:77)
	at io.ktor.server.routing.Routing$executeResult$$inlined$execute$1.invokeSuspend(Pipeline.kt:478)
	at io.ktor.server.routing.Routing$executeResult$$inlined$execute$1.invoke(Pipeline.kt)
	at io.ktor.server.routing.Routing$executeResult$$inlined$execute$1.invoke(Pipeline.kt)
	at io.ktor.util.debug.ContextUtilsKt.initContextInDebugMode(ContextUtils.kt:17)
	at io.ktor.server.routing.Routing.executeResult(Routing.kt:190)
	at io.ktor.server.routing.Routing.interceptor(Routing.kt:64)
	at io.ktor.server.routing.Routing$Plugin$install$1.invokeSuspend(Routing.kt:140)
	at io.ktor.server.routing.Routing$Plugin$install$1.invoke(Routing.kt)
	at io.ktor.server.routing.Routing$Plugin$install$1.invoke(Routing.kt)
	at io.ktor.util.pipeline.SuspendFunctionGun.loop(SuspendFunctionGun.kt:120)
	at io.ktor.util.pipeline.SuspendFunctionGun.proceed(SuspendFunctionGun.kt:78)
	at io.ktor.server.engine.BaseApplicationEngineKt$installDefaultTransformationChecker$1.invokeSuspend(BaseApplicationEngine.kt:124)
	at io.ktor.server.engine.BaseApplicationEngineKt$installDefaultTransformationChecker$1.invoke(BaseApplicationEngine.kt)
	at io.ktor.server.engine.BaseApplicationEngineKt$installDefaultTransformationChecker$1.invoke(BaseApplicationEngine.kt)
	at io.ktor.util.pipeline.SuspendFunctionGun.loop(SuspendFunctionGun.kt:120)
	at io.ktor.util.pipeline.SuspendFunctionGun.proceed(SuspendFunctionGun.kt:78)
	at io.ktor.util.pipeline.SuspendFunctionGun.execute$ktor_utils(SuspendFunctionGun.kt:98)
	at io.ktor.util.pipeline.Pipeline.execute(Pipeline.kt:77)
	at io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1$invokeSuspend$$inlined$execute$1.invokeSuspend(Pipeline.kt:478)
	at io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1$invokeSuspend$$inlined$execute$1.invoke(Pipeline.kt)
	at io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1$invokeSuspend$$inlined$execute$1.invoke(Pipeline.kt)
	at io.ktor.util.debug.ContextUtilsKt.initContextInDebugMode(ContextUtils.kt:17)
	at io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1.invokeSuspend(DefaultEnginePipeline.kt:123)
	at io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1.invoke(DefaultEnginePipeline.kt)
	at io.ktor.server.engine.DefaultEnginePipelineKt$defaultEnginePipeline$1.invoke(DefaultEnginePipeline.kt)
	at io.ktor.util.pipeline.SuspendFunctionGun.loop(SuspendFunctionGun.kt:120)
	at io.ktor.util.pipeline.SuspendFunctionGun.proceed(SuspendFunctionGun.kt:78)
	at io.ktor.util.pipeline.SuspendFunctionGun.execute$ktor_utils(SuspendFunctionGun.kt:98)
	at io.ktor.util.pipeline.Pipeline.execute(Pipeline.kt:77)
	at io.ktor.server.netty.NettyApplicationCallHandler$handleRequest$1$invokeSuspend$$inlined$execute$1.invokeSuspend(Pipeline.kt:478)
	at io.ktor.server.netty.NettyApplicationCallHandler$handleRequest$1$invokeSuspend$$inlined$execute$1.invoke(Pipeline.kt)
	at io.ktor.server.netty.NettyApplicationCallHandler$handleRequest$1$invokeSuspend$$inlined$execute$1.invoke(Pipeline.kt)
	at io.ktor.util.debug.ContextUtilsKt.initContextInDebugMode(ContextUtils.kt:17)
	at io.ktor.server.netty.NettyApplicationCallHandler$handleRequest$1.invokeSuspend(NettyApplicationCallHandler.kt:119)
	at io.ktor.server.netty.NettyApplicationCallHandler$handleRequest$1.invoke(NettyApplicationCallHandler.kt)
	at io.ktor.server.netty.NettyApplicationCallHandler$handleRequest$1.invoke(NettyApplicationCallHandler.kt)
	at kotlinx.coroutines.intrinsics.UndispatchedKt.startCoroutineUndispatched(Undispatched.kt:44)
	at kotlinx.coroutines.CoroutineStart.invoke(CoroutineStart.kt:112)
	at kotlinx.coroutines.AbstractCoroutine.start(AbstractCoroutine.kt:126)
	at kotlinx.coroutines.BuildersKt__Builders_commonKt.launch(Builders.common.kt:56)
	at kotlinx.coroutines.BuildersKt.launch(Unknown Source)
	at io.ktor.server.netty.NettyApplicationCallHandler.handleRequest(NettyApplicationCallHandler.kt:37)
	at io.ktor.server.netty.NettyApplicationCallHandler.channelRead(NettyApplicationCallHandler.kt:29)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:444)
	at io.netty.channel.AbstractChannelHandlerContext.access$600(AbstractChannelHandlerContext.java:61)
	at io.netty.channel.AbstractChannelHandlerContext$7.run(AbstractChannelHandlerContext.java:425)
	at io.netty.util.concurrent.AbstractEventExecutor.runTask(AbstractEventExecutor.java:174)
	at io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java:167)
	at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:470)
	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:569)
	at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:997)
	at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
	at io.ktor.server.netty.EventLoopGroupProxy$Companion.create$lambda$1$lambda$0(NettyApplicationEngine.kt:296)
	at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
	at java.base/java.lang.Thread.run(Thread.java:829)