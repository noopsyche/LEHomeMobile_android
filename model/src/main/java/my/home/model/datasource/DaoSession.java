/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package my.home.model.datasource;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;
import my.home.model.entities.ChatItem;
import my.home.model.entities.Shortcut;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 *
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig chatItemDaoConfig;
    private final DaoConfig shortcutDaoConfig;

    private final ChatItemDao chatItemDao;
    private final ShortcutDao shortcutDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        chatItemDaoConfig = daoConfigMap.get(ChatItemDao.class).clone();
        chatItemDaoConfig.initIdentityScope(type);

        shortcutDaoConfig = daoConfigMap.get(ShortcutDao.class).clone();
        shortcutDaoConfig.initIdentityScope(type);

        chatItemDao = new ChatItemDao(chatItemDaoConfig, this);
        shortcutDao = new ShortcutDao(shortcutDaoConfig, this);

        registerDao(ChatItem.class, chatItemDao);
        registerDao(Shortcut.class, shortcutDao);
    }

    public void clear() {
        chatItemDaoConfig.getIdentityScope().clear();
        shortcutDaoConfig.getIdentityScope().clear();
    }

    public ChatItemDao getChatItemDao() {
        return chatItemDao;
    }

    public ShortcutDao getShortcutDao() {
        return shortcutDao;
    }

}