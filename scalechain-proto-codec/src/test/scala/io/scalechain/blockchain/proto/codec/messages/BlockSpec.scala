package io.scalechain.blockchain.proto.codec.messages

import io.scalechain.blockchain.proto._
import io.scalechain.blockchain.proto.codec._
import io.scalechain.io.HexFileLoader
import io.scalechain.util.HexUtil._
import scodec.bits.BitVector

/**
[Bitcoin Core Packets Captured]
  [NET] recv; header:
  <Header> Magic:ù¾´Ù, Command:block, Size:231721, Checksum:-2127760196
  dumping data len : 24
  00000000  f9 be b4 d9 62 6c 6f 63  6b 00 00 00 00 00 00 00  ù¾´Ùblock.......
  00000010  29 89 03 00 bc f4 2c 81                           )<89>..¼ô,<81>

  dumping data len : 231721
  00000000  04 00 00 00 33 52 85 50  87 a8 a9 03 78 96 a9 22  ....3R<85>P<87>¨©.x<96>©"
  00000010  aa c6 ff ab c9 73 15 a5  88 a7 b2 03 00 00 00 00  ªÆÿ«És.¥<88>§².....
  00000020  00 00 00 00 b1 a7 95 87  8d a6 e1 e0 92 4f 71 8d  ....±§<95><87><8d>¦áà<92>Oq<8d>
  ... omitted .............. full data at /block-size231721.hex
  */
class BlockSpec extends EnvelopeTestSuite[Block]  {

  val codec = BlockCodec.codec

  val envelopeHeader = bytes(
    """
      f9 be b4 d9 62 6c 6f 63  6b 00 00 00 00 00 00 00
      29 89 03 00 bc f4 2c 81
    """)

  val payload = HexFileLoader.load("data/unittest/codec/block-size231721.hex")

  val envelope = BitcoinMessageEnvelope(
    Magic.MAIN,
    "block",
    payload.length.toInt,
    Checksum.fromHex("bc f4 2c 81"),
    BitVector.view(payload)
  )

  // Do not test
  val message = null
}
