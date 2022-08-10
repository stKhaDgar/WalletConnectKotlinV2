package com.walletconnect.sign.di

import com.walletconnect.sign.crypto.Codec
import com.walletconnect.sign.crypto.data.codec.ChaChaPolyCodec
import com.walletconnect.sign.json_rpc.data.JsonRpcSerializer
import com.walletconnect.sign.json_rpc.domain.RelayerInteractor
import com.walletconnect.sign.util.NetworkState
import org.koin.dsl.module

@JvmSynthetic
internal fun relayerModule() = module {

    //todo: move to crypto module in android_core
    single<Codec> {
        ChaChaPolyCodec(get())
    }

    single {
        JsonRpcSerializer(get())
    }

    single {
        NetworkState(get())
    }

    //todo: change name to JsonRpcInteractor
    single {
        RelayerInteractor(get(), get(), get(), get(), get())
    }
}