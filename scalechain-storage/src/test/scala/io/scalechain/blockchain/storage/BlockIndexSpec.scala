package io.scalechain.blockchain.storage

import org.scalatest._

/**
  * Created by kangmo on 11/2/15.
  */
class BlockIndexSpec extends FlatSpec with BeforeAndAfterEach with Matchers {
  this: Suite =>

  Storage.initialize()

  override def beforeEach() {
    super.beforeEach()
  }

  override def afterEach() {
    super.afterEach()

  }

  // BlockIndex is a trait. No need to create test cases for a trait.
}

