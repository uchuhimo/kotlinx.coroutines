/*
 * Copyright 2016-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// This file was automatically generated from coroutines-guide-reactive.md by Knit tool. Do not edit.
package guide.reactive.basic.example09

import kotlinx.coroutines.experimental.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.experimental.channels.consumeEach
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.yield

fun main(args: Array<String>) = runBlocking<Unit> {
    val broadcast = ConflatedBroadcastChannel<String>()
    broadcast.offer("one")
    broadcast.offer("two")
    // now launch a coroutine to print everything
    launch(context) { // use the context of the main thread for a coroutine
        broadcast.consumeEach { println(it) }
    }
    broadcast.offer("three")
    yield() // yield the main thread to the launched coroutine
    broadcast.offer("four")
}
