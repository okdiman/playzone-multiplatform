//
//  SearchScreen.swift
//  iosApp
//
//  Created by Дмитрий Окунев on 11.11.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct SearchScreen: View {
    
    private let viewModel = SearchViewModel()
    
    var body: some View {
        ObservingView(statePublisher: statePublisher(viewModel.viewStates())) { state in
            SearchView(viewState: state) { event in
                viewModel.obtainEvent(viewEvent: event)
            }
        }
    }
}

struct SearchScreen_Previews: PreviewProvider {
    static var previews: some View {
        SearchScreen()
    }
}
