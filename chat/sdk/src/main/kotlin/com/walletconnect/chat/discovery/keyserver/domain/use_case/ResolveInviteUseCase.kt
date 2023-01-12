@file:JvmSynthetic

package com.walletconnect.chat.discovery.keyserver.domain.use_case

import com.walletconnect.chat.common.model.AccountId
import com.walletconnect.chat.discovery.keyserver.data.client.KeyServerClient
import com.walletconnect.chat.discovery.keyserver.data.service.KeyServerService

internal class ResolveInviteUseCase(
    private val client: KeyServerClient,
) {
    suspend operator fun invoke(accountId: AccountId): Result<KeyServerService.ResolveInviteResponse> = runCatching {
        client.resolveInvite(accountId.value)
    }
}