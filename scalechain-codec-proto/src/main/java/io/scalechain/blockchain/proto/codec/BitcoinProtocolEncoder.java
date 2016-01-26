/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.scalechain.blockchain.proto.codec;

import io.netty.buffer.*;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.scalechain.blockchain.proto.ProtocolMessage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Encodes the requested case class that represents a bitcoin protocol message into a {@link ByteBuf}.
 */
@Sharable
public class BitcoinProtocolEncoder extends MessageToMessageEncoder<ProtocolMessage> {
    /**
     * Creates a new instance .
     */
    public BitcoinProtocolEncoder() {
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, ProtocolMessage msg, List<Object> out) throws Exception {
        System.out.println("[Debug] BitcoinProtocolEncoder : " + msg.toString());

        // TODO : Make sure that we are not having any performance issue here.
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        BitcoinProtocolCodec codec = new BitcoinProtocolCodec();
        codec.encode( msg, bout);

        ByteBuf buffer = Unpooled.wrappedBuffer(bout.toByteArray());
        out.add( buffer );
    }
}