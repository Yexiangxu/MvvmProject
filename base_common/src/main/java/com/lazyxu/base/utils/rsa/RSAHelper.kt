package com.lazyxu.base.utils.rsa

import java.nio.charset.Charset
import java.security.KeyFactory
import java.security.PrivateKey
import java.security.PublicKey
import java.security.Signature
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec

/**
 * Created by Administrator on 2016/7/6.
 */
object RSAHelper {
    /**
     * 加密算法RSA
     */
    const val RSA = "RSA"
    /**
     * 加密算法RSA 公钥
     */
    private const val public_key = "\n" +
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDCXhIFBvPoxYg7BCM2VPK7Gqd0\n" +
            "76ysQg5G+56pbLZM+dP04hVa5DcSmOCrLExIdDjgCj1NInF8Cr6wZ4zquzRa+X09\n" +
            "8fwPUNU7jXqXsqPj7oYN4xCg77MrL7NarMiauC2JMouuUfe6Hswvg9xCGlTBO6gk\n" +
            "o+3bCFb0YFUaew2ocwIDAQAB\n"
    /**
     * 加密算法RSA 私钥
     */
    private const val private_key = "\n" +
            "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMJeEgUG8+jFiDsE\n" +
            "IzZU8rsap3TvrKxCDkb7nqlstkz50/TiFVrkNxKY4KssTEh0OOAKPU0icXwKvrBn\n" +
            "jOq7NFr5fT3x/A9Q1TuNepeyo+Puhg3jEKDvsysvs1qsyJq4LYkyi65R97oezC+D\n" +
            "3EIaVME7qCSj7dsIVvRgVRp7DahzAgMBAAECgYEAwJK7f8eXubScePxsdtRLeh26\n" +
            "dB1TE4iO5L1AQdS3+iQ8YI/vYJJkDkTxtCa7nb2o7DC488eAcMmkjNrLv3WjNBGg\n" +
            "bOCk0YxwAS6b7H36ax5+HAzHldopd8R8S/+qfl2NB7RrE28CIeaK0zfSp5c9O1WF\n" +
            "JEPzFhodpeBjobI8N6ECQQD/JlTnMsdctLIGtdd/6nZuBtqL4qA2rwwV5E7rYNOH\n" +
            "hmZf1MBPgsSvEUT1Txb6mFc3eObHhp2uSxj4aAe/38VtAkEAwwPipqNMJMG4MkRF\n" +
            "+HEBiNmuRlah86svVilgZSOYSfNtkZ6QrCfGbCGzTYnoA4D7OAUQkHCpiBS4Ux55\n" +
            "MxLZXwJBANNg2DnpsYw2Dr7Ma0oH3jFs8CWvjHeBMYv5ZwBNaTD/wVRnFyNH/NXk\n" +
            "grKP4UOebbMBMH/gIEXC5V72IGVvZ0kCQGqWeQ7zOe7tIqv2vPepbFlMAQDY4PO5\n" +
            "oMnLG7Cr39SrhDuPGyu9IaqAUOwUcAdaO/TGb+NCcKa8DHMBuOS9bKkCQATbivRx\n" +
            "tO0jPUC6KJH90j4PmdsycT/lF4lJAaBsq2gLxn3MZucVOVM5rYaKnxs7Uh2TcGu+\n" +
            "+KnLOiPHw9Gaj8g="

    /**
     * 加签
     */
    fun sign(data: String): String {
        return try {
            val privateKey = privateKey
            val signature = Signature.getInstance("Sha1WithRSA")
            signature.initSign(privateKey)
            signature.update(data.toByteArray(Charset.forName("UTF-8")))
            val signed = signature.sign()
            Base64Utils.encode(signed)
        } catch (e: Exception) {
            ""
        }
    }

    /**
     * 获取私钥
     * @return
     */
    private val privateKey: PrivateKey?
        private get() {
            val bytesPrivate = Base64Utils.decode(private_key)
            val keySpec = PKCS8EncodedKeySpec(bytesPrivate)
            return try {
                val keyFactory = KeyFactory.getInstance("RSA")
                keyFactory.generatePrivate(keySpec)
            } catch (e: Exception) {
                null
            }
        }

    /**
     * 验签
     * @param data
     * @param sign
     * @return
     */
    fun verify(data: String, sign: String?): Boolean {
        return try {
            val publicKey = publicKey
            val signature = Signature.getInstance("Sha1WithRSA")
            signature.initVerify(publicKey)
            signature.update(data.toByteArray(Charset.forName("UTF-8")))
            val signby = Base64Utils.decode(sign)
            signature.verify(signby)
        } catch (e: Exception) {
            false
        }
    }

    /**
     * 获取公钥
     * @return PublicKey
     */
    private val publicKey: PublicKey?
        private get() {
            val bytesPublic = Base64Utils.decode(public_key)
            val keySpec = X509EncodedKeySpec(bytesPublic)
            return try {
                val keyFactory = KeyFactory.getInstance("RSA")
                keyFactory.generatePublic(keySpec)
            } catch (e: Exception) {
                null
            }
        }
}